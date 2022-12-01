package com.epam.poc.commons;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }
}
