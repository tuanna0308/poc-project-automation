package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.HomePageObject;
import com.epam.poc.pageObjects.homepage.CategoriesTilesSectionObject;
import com.epam.poc.utilities.RandomUtil;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.epam.poc.pageUIs.homepage.CategoriesTilesSectionUI.*;

@Listeners({TestListener.class})
@Epic("Regression test")
@Feature("HomePage")
public class CategoriesTilesSectionTest extends BaseTest {

    private CategoriesTilesSectionObject categoriesTilesSection;
    private HomePageObject homePageObject;
    private RandomUtil randomUtil;

    @BeforeMethod
    public void beforeMethod() {
        categoriesTilesSection = new CategoriesTilesSectionObject(driver);
        homePageObject = new HomePageObject(driver);
        randomUtil = new RandomUtil();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: Verify random category in Home Page")
    @Story("Categories tiles section")
    @Parameters({"pageUrl"})
    public void verifyRandomCategoryHomePage() {
        //Click shopee icon to back to homepage
        categoriesTilesSection.clickToElement(driver, By.cssSelector(SHOPEE_ICON_CSS));

        //Close popup
        homePageObject.closeHomePagePopup();

        //get a random category
        WebElement randomCategory = categoriesTilesSection.getRandomCategory();
        categoriesTilesSection.clickForwardButtonIfElementNotDisplay(randomCategory);
        String categoryText = categoriesTilesSection.getElementText(randomCategory);

        //Check "All Category" section
        categoriesTilesSection.clickToElementByJS(driver, randomCategory);
        categoriesTilesSection.waitForElementUntilVisible(driver, By.cssSelector(MAIN_CATEGORY_CSS));
        Assert.assertEquals(categoryText, categoriesTilesSection.getElementText(driver, By.cssSelector(MAIN_CATEGORY_CSS)));

        //check 10 random products
        int listProductSize = categoriesTilesSection.getElements(driver, By.cssSelector(SEARCH_ITEMS_CSS)).size();
        for (int i = 0; i < 10; i++) {
            int rand = randomUtil.getRandomNumberInBorder(listProductSize - 1) + 1;
            categoriesTilesSection.scrollThenClickToElement(driver, By.cssSelector(searchItemByIndexCss(rand)));
            categoriesTilesSection.waitForElementUntilVisible(driver, By.xpath(PRODUCT_SPECIFICATIONS_CATEGORY_XPATH));
            Assert.assertEquals(categoriesTilesSection.getElementText(driver, By.xpath(PRODUCT_SPECIFICATIONS_CATEGORY_XPATH)), categoryText);
            categoriesTilesSection.navigateToPreviousPage(driver);
        }
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: Verify forward and back arrows in Home Page")
    @Story("Categories tiles section")
    @Parameters({"pageUrl"})
    public void verifyForwardAndBackArrowsHomePage() {
        //Close popup
        homePageObject.closeHomePagePopup();
        homePageObject.staticWait(1);

        //check when click forward button
        categoriesTilesSection.scrollThenClickToElement(driver, By.xpath(HOME_CATEGORY_LIST_FORWARD_ARROWS_XPATH));
        categoriesTilesSection.waitForElementUntilVisible(driver, By.xpath(HOME_CATEGORY_LIST_BACK_ARROWS_XPATH));
        Assert.assertFalse(categoriesTilesSection.isElementDisplayed(driver, By.xpath(HOME_CATEGORY_LIST_FORWARD_ARROWS_XPATH)));
        Assert.assertTrue(categoriesTilesSection.isElementDisplayed(driver, By.xpath(HOME_CATEGORY_LIST_BACK_ARROWS_XPATH)));
        categoriesTilesSection.verifyClickCategoryHomePage(By.xpath(LAST_CATEGORY_HOMEPAGE_XPATH));

        categoriesTilesSection.navigateToPreviousPage(driver);
        homePageObject.closeHomePagePopup();

        categoriesTilesSection.scrollThenClickToElement(driver, By.xpath(HOME_CATEGORY_LIST_FORWARD_ARROWS_XPATH));
        //check when click back button
        categoriesTilesSection.waitForElementUntilClickable(driver, By.xpath(HOME_CATEGORY_LIST_BACK_ARROWS_XPATH));
        categoriesTilesSection.clickToElement(driver, By.xpath(HOME_CATEGORY_LIST_BACK_ARROWS_XPATH));
        categoriesTilesSection.waitForElementUntilVisible(driver, By.xpath(HOME_CATEGORY_LIST_FORWARD_ARROWS_XPATH));
        Assert.assertFalse(categoriesTilesSection.isElementDisplayed(driver, By.xpath(HOME_CATEGORY_LIST_BACK_ARROWS_XPATH)));
        Assert.assertTrue(categoriesTilesSection.isElementDisplayed(driver, By.xpath(HOME_CATEGORY_LIST_FORWARD_ARROWS_XPATH)));
        categoriesTilesSection.verifyClickCategoryHomePage(By.xpath(FIRST_CATEGORY_HOMEPAGE_XPATH));

    }
}
