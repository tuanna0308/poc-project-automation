package com.epam.poc.commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    protected Logger logger;

    protected BasePage() {
        logger = LogManager.getLogger(getClass());
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public WebElement getElement(WebDriver driver, By by) {
        return driver.findElement(by);
    }

    public List<WebElement> getElements(WebDriver driver, By by) {
        return driver.findElements(by);
    }

    public String getElementText(WebDriver driver, By by) {
        return getElement(driver, by).getText();
    }

    public void sendKeyToElement(WebDriver driver, By by, String value) {
        getElement(driver, by).clear();
        getElement(driver, by).sendKeys(value);
    }

    public void clickToElement(WebDriver driver, By by) {
        getElement(driver, by).click();
    }

    public boolean isElementDisplayed(WebDriver driver, By by) {
        return getElement(driver, by).isDisplayed();
    }
}
