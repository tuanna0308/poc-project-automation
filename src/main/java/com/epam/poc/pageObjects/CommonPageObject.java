package com.epam.poc.pageObjects;

import com.epam.poc.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.epam.poc.pageUIs.CommonPageUI.SHOPEE_LOGO_CSS;

public class CommonPageObject extends BasePage {
    private final WebDriver driver;

    public CommonPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Shopee Logo")
    public void clickShopeeLogo() {
        scrollThenClickToElement(driver, By.cssSelector(SHOPEE_LOGO_CSS));
    }

    @Step("Scroll to bottom of page")
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
}
