package com.epam.poc.pageObjects;

import com.epam.poc.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class HelpPageObject extends BasePage {
    private final WebDriver driver;

    public HelpPageObject(WebDriver driver){
        this.driver = driver;
    }
}
