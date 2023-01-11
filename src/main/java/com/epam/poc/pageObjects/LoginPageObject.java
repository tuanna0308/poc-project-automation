package com.epam.poc.pageObjects;

import com.epam.poc.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    private final WebDriver driver;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }
}
