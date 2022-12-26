package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.HomePageObject;
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
@Epic("Smoke test")
@Feature("HomePage")
public class PopularCategoriesMenuTest extends BaseTest {

    private PopularCategoriesMenuObject popularCategoriesMenu;
    private HomePageObject homePage;

    @BeforeMethod
    public void beforeMethod() {
        popularCategoriesMenu = new PopularCategoriesMenuObject(driver);
        homePage = new HomePageObject(driver);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: Verify relevant information display")
    @Story("Popular categories menu")
    @Parameters({"pageUrl"})
    public void verifyRelevantInformationDisplay(String pageUrl) {

        // Verify the first popular category
        homePage.closeHomePagePopup();
        List<WebElement> popularCategories = popularCategoriesMenu.getElements(driver,
                By.xpath(PopularCategoriesMenuUI.POPULAR_CATEGORIES_MENU_XPATH));
        String popularCategoryText = popularCategoriesMenu.getElementTextByIndex(popularCategories, 1);
        popularCategoriesMenu.clickToElementByIndex(popularCategories, 1);

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
                popularCategoriesMenu.getElementValue(driver, By.xpath(PopularCategoriesMenuUI.SEARCH_INPUT_XPATH)));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: Verify first 10 products have relevant content")
    @Story("Popular categories menu")
    @Parameters({"pageUrl"})
    public void verifyFirstTenProductsWithRelevantInformation(String pageUrl) {

        // Verify the first popular category
        homePage.closeHomePagePopup();
        List<WebElement> popularCategories = popularCategoriesMenu.getElements(driver,
                By.xpath(PopularCategoriesMenuUI.POPULAR_CATEGORIES_MENU_XPATH));
        String popularCategoryText = popularCategoriesMenu.getElementTextByIndex(popularCategories, 1);
        popularCategoriesMenu.clickToElementByIndex(popularCategories, 1);

        // Verify URL
        String urlExpected = pageUrl + PageURL.SEARCH_URL + "?keyword=" + popularCategoryText.toLowerCase();
        String urlActual = URLDecoder.decode(driver.getCurrentUrl());
        Assert.assertEquals(urlExpected, urlActual);

        // Verify first 10 products have relevant content
        List<WebElement> products = popularCategoriesMenu.getElementWithLimitNumber(
                popularCategoriesMenu.getElements(driver,  By.className(PopularCategoriesMenuUI.PRODUCT_CARDS_CLASS_NAME)),
                10);

        for (WebElement product: products) {
            boolean isProductTitleContainsKeyword = popularCategoriesMenu.isContainsKeyword(popularCategoryText,
                    popularCategoriesMenu.getProductCardTitleByCard(product));
            Assert.assertTrue(isProductTitleContainsKeyword);
        }
    }
}
