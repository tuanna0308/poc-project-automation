package com.epam.poc.pageObjects.homepage;

import com.epam.poc.commons.BasePage;
import com.epam.poc.pageUIs.homepage.TopProductsPageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.Color;

import java.util.List;

public class TopProductsPageObject extends BasePage {

    private final WebDriver driver;
    private static final String HIGHLIGHT_COLOR = "#ee4d2d";

    public TopProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean validateTopProductsSection() {
        waitForElementUntilVisible(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_TITLE));
        if (!isElementDisplayed(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_TITLE))
            || !isElementDisplayed(driver, By.xpath(TopProductsPageUI.SEE_MORE_BUTTON))) {
            return false;
        }
        if (!validateTopProductItem()) {
            return false;
        }
        return true;
    }

    public boolean validateTopProductItem() {
        List<WebElement> products = getElements(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_LIST));
        for (WebElement product : products) {
            if (!product.findElement(By.xpath(TopProductsPageUI.TOP_PRODUCT_ITEM_TAG))
                    .getCssValue("background-image")
                    .contains("url(https://deo.shopeemobile.com/shopee/shopee-pcmall-live-sg/homepage/06720e49514cbd94b7552496b4de454a.png)")) {
                return false;
            }
            if (!product.findElement(By.xpath(TopProductsPageUI.TOP_PRODUCT_ITEM_IMAGE)).isDisplayed()) {
                return false;
            }
            if (!product.findElement(By.xpath(TopProductsPageUI.TOP_PRODUCT_ITEM_SOLD_IN_MONTH)).isDisplayed()) {
                return false;
            }
            String categoryName = getElementText(product.findElement(By.xpath(TopProductsPageUI.TOP_PRODUCT_ITEM_CATEGORY)));
            if (categoryName.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Step("Click See More button in Top Products Section")
    public void clickSeeMoreButtonTopProducts() {
        scrollThenClickToElement(driver, By.xpath(TopProductsPageUI.SEE_MORE_BUTTON));
    }

    @Step("Validate Top Product Page Title is displayed")
    public boolean validateTopProductPageTitleDisplay() {
        waitForPageLoadedCompletely(driver);
        return getElement(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_PAGE_TITLE)).isDisplayed();
    }

    @Step("Validate first tab of top product is highlighted")
    public boolean validateFirstTopProductTabActive() {
        return Color.fromString(getElement(driver, By.xpath(TopProductsPageUI.FIRST_TOP_PRODUCT_TAB)).getCssValue("color"))
                .asHex().equals(HIGHLIGHT_COLOR);
    }

}
