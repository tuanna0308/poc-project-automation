package com.epam.poc.commons;

import com.epam.poc.configs.drivers.DriverConfig;
import com.epam.poc.pageObjects.HelpPageObject;
import com.epam.poc.pageObjects.LoginPageObject;
import com.epam.poc.pageObjects.SignUpPageObject;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected static WebDriver driver = null;

    protected HomePageObject homePage;
    protected HelpPageObject helpPage;
    protected SignUpPageObject signUpPage;
    protected LoginPageObject loginPage;

    protected Logger logger;

    protected BaseTest() {
        logger = LogManager.getLogger(getClass());
    }

    @Parameters({"pageUrl", "browserName"})
    @BeforeClass
    public void setUp(String pageUrl, String browserName) {
        logger.info("Page Url: " + pageUrl + " with browser name: " + browserName);

        driver = DriverConfig.getDriver(browserName);
        driver.get(pageUrl);

        homePage = new HomePageObject(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverConfig.quiteDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
