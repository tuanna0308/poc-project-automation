package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import com.epam.poc.pageObjects.homepage.TopProductsPageObject;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
@Epic("Regression test")
@Feature("HomePage")
public class TopProductsTests extends BaseTest {
    private TopProductsPageObject topProductsPO;

    @BeforeMethod
    public void beforeMethod() {
        topProductsPO = new TopProductsPageObject(driver);
        homePage = new HomePageObject(driver);
        homePage.closeHomePagePopup();
        homePage.loadTopProductsSection();
    }

    @Test()
    @Description("Verify Top Products section in Homepage")
    @Story("Top Products section")
    public void verifyTopProductsSection() {
        Assert.assertTrue(topProductsPO.validateTopProductsSection());
    }
}