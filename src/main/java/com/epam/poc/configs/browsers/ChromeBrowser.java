package com.epam.poc.configs.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser {

    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        // Set options for Chrome browser
        options.addArguments("--lang=vi");

        return new ChromeDriver(options);
    }
}
