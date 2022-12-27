package com.epam.poc.commons;

import com.epam.poc.utilities.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class BasePage {
    protected Logger logger;
   private PropertyReader propertyReader = new PropertyReader(GlobalConstants.CONFIG_FILE_KEY);

    protected BasePage() {
        logger = LogManager.getLogger(getClass());
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public WebElement getElement(WebDriver driver, By by) {
        return driver.findElement(by);
    }


    public WebElement getElementByJavascriptExecutor(WebDriver driver, String executeScript) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        return  (WebElement) jse.executeScript(executeScript);
    }


    public List<WebElement> getElements(WebDriver driver, By by) {
        return driver.findElements(by);
    }

    public String getElementText(WebDriver driver, By by) {
        return getElement(driver, by).getText();
    }

    public String getElementTextByIndex(List<WebElement> elements, int index) {
        return elements.get(index).getText();
    }

    public String getElementByAttribute(WebDriver driver, By by, String attribute) {
        return driver.findElement(by).getAttribute(attribute);
    }

    public List<WebElement> getElementWithLimitNumber(List<WebElement> elements, int numberOfElement) {
        return elements.stream().limit(numberOfElement).collect(Collectors.toList());
    }

    public void sendKeyToElement(WebDriver driver, By by, String value) {
        getElement(driver, by).clear();
        getElement(driver, by).sendKeys(value);
    }

    public void clickToElement(WebDriver driver, By by) {
        getElement(driver, by).click();
    }

    public void clickToElementByIndex(List<WebElement> elements, int index) {
        elements.get(index).click();
    }

    public boolean isElementDisplayed(WebDriver driver, By by) {
        return getElement(driver, by).isDisplayed();
    }

    public void waitForElementUntilClickable(WebDriver driver, WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(propertyReader.getValue(GlobalConstants.LONG_TIMEOUT_KEY)));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (Exception e) {
            logger.info("Element not clickable");
        }
    }

    public void waitForElementUntilInvisible(WebDriver driver, WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(propertyReader.getValue(GlobalConstants.LONG_TIMEOUT_KEY)));
            wait.until(ExpectedConditions.invisibilityOf(element));
        }
        catch (Exception e) {
            logger.info("Element is visibility");
        }
    }
}
