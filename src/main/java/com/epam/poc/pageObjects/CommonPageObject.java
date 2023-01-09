package com.epam.poc.pageObjects;

import com.epam.poc.commons.BasePage;
import org.openqa.selenium.WebDriver;
public class CommonPageObject extends BasePage {
    private final WebDriver driver;

    public CommonPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
