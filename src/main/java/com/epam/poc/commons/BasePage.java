package com.epam.poc.commons;

import org.openqa.selenium.WebDriver;


public class BasePage {
    public WebDriver driver;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

}
