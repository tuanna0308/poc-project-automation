package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.HomePageObject;
import com.epam.poc.pageObjects.homepage.PopularCategoriesMenuObject;
import com.epam.poc.utilities.constants.PageURL;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URLDecoder;
import java.util.List;
import java.util.stream.Collectors;

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
        popularCategoriesMenu.clickToPopularCategoryByIndex(0);
        String popularCategoryText = popularCategoriesMenu.getTextPopularCategoryByIndex(0);

        // Verify URL
        String urlExpected = pageUrl + PageURL.SEARCH_URL + "?keyword=" + popularCategoryText.toLowerCase();
        String urlActual = URLDecoder.decode(driver.getCurrentUrl());
        Assert.assertEquals(urlExpected, urlActual);

        // Verify shop section
        String shopResultSearchLabelExpected = "Shop liên quan đến \"" + popularCategoryText.toLowerCase() + "\"";
        String shopResultSearchLabelActual = popularCategoriesMenu.getShopSearchResultLabel();
        Assert.assertEquals(shopResultSearchLabelExpected, shopResultSearchLabelActual);
        Assert.assertEquals(true, popularCategoriesMenu.isShopSearchResultCardItemDisplayed());

        // Verify product section
        String productSearchResultLabelExpected = "Kết quả tìm kiếm cho từ khoá '" + popularCategoryText.toLowerCase() + "'";
        String productSearchResultLabelActual = popularCategoriesMenu.getProductSearchResultLabel();
        Assert.assertEquals(productSearchResultLabelExpected, productSearchResultLabelActual);
        boolean isProductTitleContainsKeyword = popularCategoriesMenu.isContainsKeyword(popularCategoryText, popularCategoriesMenu.getProductCardTitle());
        Assert.assertEquals(true,  isProductTitleContainsKeyword);

        // Verify search section
        Assert.assertEquals(popularCategoryText.toLowerCase(), popularCategoriesMenu.getSearchInputValue());
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: Verify first 10 products have relevant content")
    @Story("[US 25] Popular categories menu")
    @Parameters({"pageUrl"})
    public void verifyFirstTenProductsWithRelevantInformation(String pageUrl) {

        // Verify the first popular category
        homePage.closeHomePagePopup();
        popularCategoriesMenu.clickToPopularCategoryByIndex(0);
        String popularCategoryText = popularCategoriesMenu.getTextPopularCategoryByIndex(0);

        // Verify URL
        String urlExpected = pageUrl + PageURL.SEARCH_URL + "?keyword=" + popularCategoryText.toLowerCase();
        String urlActual = URLDecoder.decode(driver.getCurrentUrl());
        Assert.assertEquals(urlExpected, urlActual);

        // Verify first 10 products have relevant content
        List<WebElement> products = popularCategoriesMenu.getProductCards().stream().limit(10).collect(Collectors.toList());
        for (WebElement product: products) {
            boolean isProductTitleContainsKeyword = popularCategoriesMenu.isContainsKeyword(popularCategoryText, popularCategoriesMenu.getProductCardTitleByCard(product));
            Assert.assertEquals(true,  isProductTitleContainsKeyword);
        }
    }
}
