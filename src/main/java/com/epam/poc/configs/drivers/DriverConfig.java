package com.epam.poc.configs.drivers;

import com.epam.poc.commons.GlobalConstants;
import com.epam.poc.configs.browsers.BrowserName;
import com.epam.poc.configs.browsers.ChromeBrowser;
import com.epam.poc.configs.browsers.FirefoxBrowser;
import com.epam.poc.utilities.PropertyReader;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverConfig {

    private static WebDriver driver;

    private DriverConfig() {}

    public static WebDriver getDriver(String browserName) {
        BrowserName browserNameEnum = BrowserName.valueOf(browserName.toUpperCase());

        if (driver == null) {
            switch (browserNameEnum) {
                case CHROME:
                    driver = new ChromeBrowser().getDriver();
                    break;
                case FIREFOX:
                    driver = new FirefoxBrowser().getDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Please check the browser name again!");
            }
        }
        driver.manage().window().maximize();

        PropertyReader propertyReader = new PropertyReader(GlobalConstants.CONFIG_FILE_KEY);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(propertyReader.getValue(GlobalConstants.SHORT_TIMEOUT_KEY)), TimeUnit.SECONDS);

        return driver;
    }

    public static void quiteDriver() {
        if (driver != null)
            driver.quit();
        driver = null;
    }
}
