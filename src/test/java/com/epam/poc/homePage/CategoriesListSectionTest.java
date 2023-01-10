package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.homepage.CategoriesListSectionObject;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
@Epic("Regression test")
@Feature("HomePage")
public class CategoriesListSectionTest extends BaseTest {
    private CategoriesListSectionObject categoriesListSection;

    @BeforeClass
    public void beforeClass() {
        categoriesListSection = new CategoriesListSectionObject(driver);
        homePage = new HomePageObject(driver);

        homePage.closeHomePagePopup();
    }

    @Test
    @Description("Test description: Verify random category in List Categories in Home Page")
    @Story("Categories list section")
    @Parameters({"pageUrl"})
    public void verifyCategoriesLink() {
        //Click random category and get name
        String expectedCategory = categoriesListSection.clickRandomCategoryAndGetName("main-category")
                .toLowerCase();

        //Wait for search field contains expected text then get placeholder
        String searchFieldPlaceholder = categoriesListSection
                .waitForSearchFieldContainsTextThenGetPlaceholder(expectedCategory);

        //Verify placeholder, search bar selector and category in list categories
        Assert.assertTrue(searchFieldPlaceholder.toLowerCase().contains(expectedCategory));
        Assert.assertTrue(categoriesListSection.getSearchbarSelectorText().toLowerCase()
                .contains(expectedCategory));
        Assert.assertEquals(expectedCategory, categoriesListSection.getMainCategoryText().toLowerCase());
    }

    @Test
    @Description("Test description: Verify random sub category in List Categories in Home Page")
    @Story("Categories list section")
    @Parameters({"pageUrl"})
    public void verifySubCategoriesLink() {
        //Back to homepage and close popup
        homePage.clickShopeeLogo().closeHomePagePopup();

        //Scroll to category list section, click random category and get name
        categoriesListSection.scrollToBottom(driver);
        String expectedCategory = categoriesListSection.clickRandomCategoryAndGetName("sub-category")
                .toLowerCase();

        //Wait for search field contains expected text then get placeholder
        String searchFieldPlaceholder = categoriesListSection
                .waitForSearchFieldContainsTextThenGetPlaceholder(expectedCategory);

        //Verify placeholder, search bar selector and category in list categories
        Assert.assertTrue(searchFieldPlaceholder.toLowerCase().contains(expectedCategory));
        Assert.assertTrue(categoriesListSection.getSearchbarSelectorText().toLowerCase()
                .contains(expectedCategory));
        Assert.assertEquals(expectedCategory, categoriesListSection.getActiveCategoryText().toLowerCase());
    }
}
