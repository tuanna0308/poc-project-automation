package com.epam.poc.pageObjects;

import com.epam.poc.commons.BasePage;
import com.epam.poc.pageUIs.CommonPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPageObject extends BasePage {
    private final WebDriver driver;

    public CommonPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
