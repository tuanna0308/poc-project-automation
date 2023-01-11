package com.epam.poc.pageObjects.homepage;

import com.epam.poc.commons.BasePage;
import com.epam.poc.pageUIs.homepage.TopProductsPageUI;
import com.epam.poc.utilities.constants.NavigationButtonType;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopProductsPageObject extends BasePage {

    private final WebDriver driver;
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

    public List<WebElement> getTopProducts() {
        return getElements(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_LIST));
    }

    @Step("Click to navigation button")
    public TopProductsPageObject clickNavigationButton(By by) {
        waitForElementUntilClickable(driver, by);
        hoverAndClickToElement(driver, by);
        staticWait(1);
        return this;
    }


    @Step("Click to all navigation buttons by type '{0}'")
    public TopProductsPageObject clickToAllNavigationButtonsByType(NavigationButtonType type) {
        int numberOfButtons = getTopProducts().size() / 5 - 1;

        for(int i = 0; i < numberOfButtons; i++) {
            if(type == NavigationButtonType.FORWARD_ARROW) {
                clickNavigationButton(By.xpath(TopProductsPageUI.TOP_PRODUCT_FORWARD_ARROWS_XPATH));
            }
            else {
                clickNavigationButton(By.xpath(TopProductsPageUI.TOP_PRODUCT_BACK_ARROWS_XPATH));
            }
        }

        if(type == NavigationButtonType.FORWARD_ARROW) {
            waitForElementUntilInvisible(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_FORWARD_ARROWS_XPATH));
        }
        else {
            waitForElementUntilInvisible(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_BACK_ARROWS_XPATH));
        }

        return this;
    }
}
