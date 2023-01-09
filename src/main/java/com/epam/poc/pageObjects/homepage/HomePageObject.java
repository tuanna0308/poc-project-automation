package com.epam.poc.pageObjects.homepage;

import com.epam.poc.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject extends BasePage {

    private final WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Close the first home page popup when opening 'shopee.vn'")
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
