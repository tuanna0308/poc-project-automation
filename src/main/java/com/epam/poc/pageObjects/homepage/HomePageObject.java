package com.epam.poc.pageObjects.homepage;

import com.epam.poc.commons.BasePage;
import com.epam.poc.pageUIs.CommonPageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject extends BasePage {

    private final WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Close the first home page popup when opening 'shopee.vn'")
    public HomePageObject closeHomePagePopup() {
        try {
            waitForPageLoadedCompletely(driver);
            staticWait(3);
            WebElement closeButton = getElementByJavascriptExecutor(driver,
                    "return document.querySelector('shopee-banner-popup-stateful').shadowRoot.querySelector('.shopee-popup__close-btn')");
            waitForElementUntilClickable(driver, closeButton);
            closeButton.click();
            waitForElementUntilInvisible(driver, closeButton);
        } catch (Exception e) {
            logger.info("Element not found");
        }
        return this;
    }

    @Step("Click Shopee Logo to back to homepage")
    public HomePageObject clickShopeeLogo() {
        clickToElement(driver, By.cssSelector(CommonPageUI.SHOPEE_LOGO_CSS));
        return this;
    }

}
