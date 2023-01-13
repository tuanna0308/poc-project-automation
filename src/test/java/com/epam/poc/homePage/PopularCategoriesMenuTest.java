package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import com.epam.poc.pageObjects.homepage.PopularCategoriesMenuObject;
import com.epam.poc.pageObjects.SearchResultObject;
import com.epam.poc.pageObjects.HeaderPageObject;
import com.epam.poc.pageUIs.SearchResultUI;
import com.epam.poc.pageUIs.HeaderPageUI;
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
    private HeaderPageObject headerPage;
    private SearchResultObject searchResult;

    @BeforeMethod
    public void beforeMethod() {
        popularCategoriesMenu = new PopularCategoriesMenuObject(driver);
        headerPage = new HeaderPageObject(driver);
        searchResult = new SearchResultObject(driver);
        homePage = new HomePageObject(driver);
        homePage.closeHomePagePopup();
    }

    @Test
    @Description("Test description: Verify relevant information display")
    @Story("Popular categories menu")
    @Parameters({"pageUrl"})
    public void verifyRelevantInformationDisplay(String pageUrl) {

        // Verify the popular category
        popularCategoriesMenu.selectCategoryByIndex(0);
        String popularCategoryText = popularCategoriesMenu.getElementTextByIndex(popularCategoriesMenu.getPopularCategories(), 0);

        // Verify URL
        String urlExpected = pageUrl + PageURL.SEARCH_URL.getUrl() + "?keyword=" + popularCategoryText.toLowerCase();
        String urlActual = URLDecoder.decode(driver.getCurrentUrl());
        Assert.assertEquals(urlExpected, urlActual);

        // Verify shop section
        String shopResultSearchLabelExpected = "Shop liên quan đến \"" + popularCategoryText.toLowerCase() + "\"";
        String shopResultSearchLabelActual = searchResult.getElementText(driver,
                By.cssSelector(SearchResultUI.SHOP_RELATED_LABEL_CSS));
        Assert.assertEquals(shopResultSearchLabelExpected, shopResultSearchLabelActual);
        Assert.assertTrue(searchResult.isElementDisplayed(driver,
                By.cssSelector(SearchResultUI.SHOP_RELATED_CARD_ITEM_CSS)));

        // Verify product section
        String productSearchResultLabelExpected = "Kết quả tìm kiếm cho từ khoá '" + popularCategoryText.toLowerCase() + "'";
        String productSearchResultLabelActual = searchResult.getElementText(driver, By.cssSelector(SearchResultUI.SEARCH_RESULT_LABEL_CSS));
        Assert.assertEquals(productSearchResultLabelExpected, productSearchResultLabelActual);
        boolean isProductTitleContainsKeyword = searchResult.isContainsKeyword(popularCategoryText,
                searchResult.getElementText(driver,
                        By.xpath(SearchResultUI.PRODUCT_CARD_TITLE_XPATH)));
        Assert.assertTrue(isProductTitleContainsKeyword);

        // Verify search section
        Assert.assertEquals(popularCategoryText.toLowerCase(),
                headerPage.getElementByAttribute(driver, By.cssSelector(HeaderPageUI.SEARCH_TEXTBOX_CSS), "value").toLowerCase());
    }

    @Test
    @Description("Test description: Verify first 10 products have relevant content")
    @Story("Popular categories menu")
    @Parameters({"pageUrl"})
    public void verifyFirstTenProductsWithRelevantInformation(String pageUrl) {

        // Verify the first popular category
        popularCategoriesMenu.selectCategoryByIndex(0);
        String popularCategoryText = popularCategoriesMenu.getElementTextByIndex(popularCategoriesMenu.getPopularCategories(), 0);

        // Verify URL
        String urlExpected = pageUrl + PageURL.SEARCH_URL.getUrl() + "?keyword=" + popularCategoryText.toLowerCase();
        String urlActual = URLDecoder.decode(driver.getCurrentUrl());
        Assert.assertEquals(urlExpected, urlActual);

        // Verify first 10 products have relevant content
        List<WebElement> productTitles = searchResult.getElementWithLimitNumber(
                searchResult.getElements(driver, By.xpath(SearchResultUI.PRODUCT_CARD_TITLE_XPATH)),
                10);

        for (WebElement title: productTitles) {
            boolean isProductTitleContainsKeyword = searchResult.isContainsKeyword(popularCategoryText, title.getText());
            Assert.assertTrue(isProductTitleContainsKeyword);
        }
    }
}
