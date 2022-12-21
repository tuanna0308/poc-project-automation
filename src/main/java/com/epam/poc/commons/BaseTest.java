package com.epam.poc.commons;

import com.epam.poc.configs.drivers.DriverConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected static WebDriver driver = null;

    protected Logger logger;

    protected BaseTest() {
        logger = LogManager.getLogger(getClass());
    }

    @Parameters({"pageUrl", "browserName"})
    @BeforeTest
    public void setUp(String pageUrl, String browserName) {
        logger.info("Page Url: " + pageUrl + " with browser name: " + browserName);

        driver = DriverConfig.getDriver(browserName);
        driver.get(pageUrl);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        DriverConfig.quiteDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
