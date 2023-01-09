package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.homepage.CategoriesListSectionObject;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.epam.poc.pageUIs.homepage.CategoriesListSectionUI.*;
import static com.epam.poc.pageUIs.homepage.CategoriesTilesSectionUI.MAIN_CATEGORY_CSS;

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
        //click random category and get name
        String expectedCategory = categoriesListSection.clickRandomCategoryAndGetName(By.xpath(MAIN_CATEGORY_XPATH), "main-category")
                .toLowerCase();

        WebElement searchField = homePage.getElement(driver, By.xpath(INPUT_SEARCH_FIELD_XPATH));
        categoriesListSection.waitForElementContainsText(driver, searchField, expectedCategory);

        //Verify placeholder, search bar selector and category in list categories
        Assert.assertTrue(searchField.getAttribute("placeholder").toLowerCase().contains(expectedCategory));
        Assert.assertTrue(categoriesListSection.getElementText(driver, By.xpath(SEARCHBAR_SELECTOR_XPATH)).toLowerCase()
                .contains(expectedCategory));
        String mainCategoryText = categoriesListSection.getElementText(driver, By.cssSelector(MAIN_CATEGORY_CSS))
                .toLowerCase();
        Assert.assertEquals(expectedCategory, mainCategoryText);
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
        String expectedCategory = categoriesListSection.clickRandomCategoryAndGetName(By.xpath(SUB_CATEGORY_XPATH), "sub-category")
                .toLowerCase();

        WebElement searchField = homePage.getElement(driver, By.xpath(INPUT_SEARCH_FIELD_XPATH));
        categoriesListSection.waitForElementContainsText(driver, searchField, expectedCategory);

        //Verify placeholder, search bar selector and category in list categories
        Assert.assertTrue(searchField.getAttribute("placeholder").toLowerCase().contains(expectedCategory));
        Assert.assertTrue(categoriesListSection.getElementText(driver, By.xpath(SEARCHBAR_SELECTOR_XPATH)).toLowerCase()
                .contains(expectedCategory));
        String mainCategoryText = categoriesListSection.getElementText(driver, By.xpath(SELECTED_CATEGORY_XPATH))
                .toLowerCase();
        Assert.assertEquals(expectedCategory, mainCategoryText);
    }
}
