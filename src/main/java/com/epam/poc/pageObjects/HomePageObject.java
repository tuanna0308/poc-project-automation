package com.epam.poc.pageObjects;

import com.epam.poc.commons.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject extends BasePage {

    private final WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void closeHomePagePopup() {
        try {
            waitForPageLoadedCompletely(driver);
            staticWait(3);
            WebElement closeButton = getElementByJavascriptExecutor(driver,
                    "return document.querySelector('shopee-banner-popup-stateful').shadowRoot.querySelector('.shopee-popup__close-btn')");
            waitForElementUntilClickable(driver, closeButton);
            closeButton.click();
            waitForElementUntilInvisible(driver, closeButton);
        }
        catch (Exception e){
            logger.info("Element not found");
        }
    }

}