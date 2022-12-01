package com.epam.poc.pages;

import com.epam.poc.commons.BasePage;
import com.epam.poc.utilities.logs.Log;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class TemplatePage extends BasePage {

    public TemplatePage(WebDriver driver) {
        super(driver);
    }

    String baseURL = "https://www.google.com/";

    @Step("Go to Google")
    public TemplatePage failedCaseTemplate() {
        Log.info("Open url");
        driver.get(baseURL);
        return this;
    }
}
