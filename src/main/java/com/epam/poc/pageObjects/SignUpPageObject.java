package com.epam.poc.pageObjects;

import com.epam.poc.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class SignUpPageObject extends BasePage {
    private final WebDriver driver;

    public SignUpPageObject(WebDriver driver){
        this.driver = driver;
    }
}
