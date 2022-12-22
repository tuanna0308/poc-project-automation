package com.epam.poc.pageObjects;

import com.epam.poc.commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomePageObject extends BasePage {

    private final WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void closeHomePagePopup() {
        // Use for selenium 4
        /*
        WebElement shoppeBannerPopup = driver.findElement(By.tagName(HomePageUI.SHOPEE_BANNER_POPUP_TAG_NAME));
        SearchContext shadowRoot = shoppeBannerPopup.getShadowRoot();
        WebElement closeButton = shadowRoot.findElement(By.className(HomePageUI.CLOSE_BUTTON_CLASS_NAME));
        closeButton.click();
        */

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            WebElement closeButton = (WebElement) jse.executeScript("return document.querySelector('shopee-banner-popup-stateful').shadowRoot.querySelector('.shopee-popup__close-btn')");
            closeButton.click();
        }
        catch (Exception e){
            logger.info("Element not found");
        }
    }

}
