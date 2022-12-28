package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import com.epam.poc.pageObjects.homepage.PopularCategoriesMenuObject;
import com.epam.poc.pageUIs.homepage.PopularCategoriesMenuUI;
import com.epam.poc.utilities.constants.PageURL;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URLDecoder;
import java.util.List;

@Listeners({TestListener.class})
@Epic("Regression test")
@Feature("HomePage")
public class PopularCategoriesMenuTest extends BaseTest {

    private PopularCategoriesMenuObject popularCategoriesMenu;
    private HomePageObject homePage;

    @BeforeMethod
    public void beforeMethod() {
        popularCategoriesMenu = new PopularCategoriesMenuObject(driver);
        homePage = new HomePageObject(driver);
        homePage.closeHomePagePopup();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: Verify relevant information display")
    @Story("Popular categories menu")
    @Parameters({"pageUrl"})
    public void verifyRelevantInformationDisplay(String pageUrl) {

        // Verify the popular category
        popularCategoriesMenu.selectCategoryByIndex(0);
        String popularCategoryText = popularCategoriesMenu.getElementTextByIndex(popularCategoriesMenu.getPopularCategories(), 0);

        // Verify URL
        String urlExpected = pageUrl + PageURL.SEARCH_URL + "?keyword=" + popularCategoryText.toLowerCase();
        String urlActual = URLDecoder.decode(driver.getCurrentUrl());
        Assert.assertEquals(urlExpected, urlActual);

        // Verify shop section
        String shopResultSearchLabelExpected = "Shop liên quan đến \"" + popularCategoryText.toLowerCase() + "\"";
        String shopResultSearchLabelActual = popularCategoriesMenu.getElementText(driver,
                By.className(PopularCategoriesMenuUI.SHOPEE_SHOP_SEARCH_RESULT_LABEL_CLASS_NAME));
        Assert.assertEquals(shopResultSearchLabelExpected, shopResultSearchLabelActual);
        Assert.assertTrue(popularCategoriesMenu.isElementDisplayed(driver,
                By.className(PopularCategoriesMenuUI.SHOPEE_SHOP_SEARCH_RESULT_CARD_ITEM_CLASS_NAME)));

        // Verify product section
        String productSearchResultLabelExpected = "Kết quả tìm kiếm cho từ khoá '" + popularCategoryText.toLowerCase() + "'";
        String productSearchResultLabelActual = popularCategoriesMenu.getElementText(driver, By.className(PopularCategoriesMenuUI.SHOPEE_PRODUCT_SEARCH_RESULT_LABEL_CLASS_NAME));
        Assert.assertEquals(productSearchResultLabelExpected, productSearchResultLabelActual);
        boolean isProductTitleContainsKeyword = popularCategoriesMenu.isContainsKeyword(popularCategoryText,
                popularCategoriesMenu.getElementText(driver,
                        By.xpath(PopularCategoriesMenuUI.PRODUCT_CARD_TITLE_XPATH)));
        Assert.assertTrue(isProductTitleContainsKeyword);

        // Verify search section
        Assert.assertEquals(popularCategoryText.toLowerCase(),
                popularCategoriesMenu.getElementByAttribute(driver, By.xpath(PopularCategoriesMenuUI.SEARCH_INPUT_XPATH), "value").toLowerCase());
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: Verify first 10 products have relevant content")
    @Story("Popular categories menu")
    @Parameters({"pageUrl"})
    public void verifyFirstTenProductsWithRelevantInformation(String pageUrl) {

        // Verify the first popular category
        popularCategoriesMenu.selectCategoryByIndex(0);
        String popularCategoryText = popularCategoriesMenu.getElementTextByIndex(popularCategoriesMenu.getPopularCategories(), 0);

        // Verify URL
        String urlExpected = pageUrl + PageURL.SEARCH_URL + "?keyword=" + popularCategoryText.toLowerCase();
        String urlActual = URLDecoder.decode(driver.getCurrentUrl());
        Assert.assertEquals(urlExpected, urlActual);

        // Verify first 10 products have relevant content
        List<WebElement> productTitles = popularCategoriesMenu.getElementWithLimitNumber(
                popularCategoriesMenu.getElements(driver, By.xpath(PopularCategoriesMenuUI.PRODUCT_CARD_TITLE_XPATH)),
                10);

        for (WebElement title: productTitles) {
            boolean isProductTitleContainsKeyword = popularCategoriesMenu.isContainsKeyword(popularCategoryText, title.getText());
            Assert.assertTrue(isProductTitleContainsKeyword);
        }
    }
}
