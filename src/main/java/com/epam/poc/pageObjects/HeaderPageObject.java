package com.epam.poc.pageObjects;

import com.epam.poc.commons.BasePage;
import com.epam.poc.pageUIs.HeaderPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPageObject extends BasePage {
    private final WebDriver driver;

    public HeaderPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
