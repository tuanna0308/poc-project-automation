package com.epam.poc.pageObjects.homepage;

import com.epam.poc.commons.BasePage;
import com.epam.poc.pageUIs.homepage.TopProductsPageUI;
import com.epam.poc.utilities.constants.NavigationButtonType;
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

    @Step("Validate Top Products section")
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

    @Step("Validate fields displayed correctly in Top Product shown")
    public boolean validateTopProductItem() {
        List<WebElement> products = getElements(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_LIST));
        for (WebElement product : products) {
            if (product.isDisplayed()) {
                if (!product.findElement(By.xpath(TopProductsPageUI.TOP_PRODUCT_ITEM_TAG))
                        .getCssValue("background-image")
                        .contains("https://deo.shopeemobile.com/shopee/shopee-pcmall-live-sg/homepage/06720e49514cbd94b7552496b4de454a.png")) {
                    return false;
                }
                if (product.findElements(By.xpath(TopProductsPageUI.TOP_PRODUCT_ITEM_IMAGE)).size() == 0) {
                    return false;
                }
                String soldInMonth = product.findElement(By.xpath(TopProductsPageUI.TOP_PRODUCT_ITEM_SOLD_IN_MONTH)).getText();
                if (!soldInMonth.matches("Bán (.*) / tháng")) {
                    return false;
                }
                if (getElementText(product.findElement(By.xpath(TopProductsPageUI.TOP_PRODUCT_ITEM_CATEGORY_NAME))).isEmpty()) {
                    return false;
                }
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
    public List<WebElement> getTopProducts() {
        return getElements(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_LIST));
    }

    @Step("Show next Top Products")
    public TopProductsPageObject showNextTopProducts() {
        waitForElementUntilClickable(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_FORWARD_ARROWS_XPATH));
        clickToElement(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_FORWARD_ARROWS_XPATH));
        staticWait(1);
        return this;
    }

    @Step("Show previous Top Products")
    public TopProductsPageObject showPreviousTopProducts() {
        waitForElementUntilClickable(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_BACK_ARROWS_XPATH));
        clickToElement(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_BACK_ARROWS_XPATH));
        staticWait(1);
        return this;
    }

    @Step("Show all Top Products by '{0}'")
    public TopProductsPageObject showAllTopProductsFromSide(NavigationButtonType type) {
        if (type == NavigationButtonType.FORWARD_ARROW) {
            while (getElement(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_FORWARD_ARROWS_XPATH)).isDisplayed()) {
                showNextTopProducts();
            }
        } else if (type == NavigationButtonType.BACK_ARROW) {
            while (getElement(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_BACK_ARROWS_XPATH)).isDisplayed()) {
                showPreviousTopProducts();
            }
        }
        return this;
    }

    @Step("Validate Show Next Top Products button disappearing")
    public boolean isShowNextTopProductsButtonDisappeared() {
        return isElementDisplayed(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_FORWARD_ARROWS_XPATH));
    }

    @Step("Validate Show Previous Top Products button disappearing")
    public boolean isShowPreviousTopProductsButtonDisappeared() {
        return isElementDisplayed(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_BACK_ARROWS_XPATH));
    }
}
