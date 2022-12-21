package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.HomePageObject;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
@Epic("Smoke test")
@Feature("HomePage")
public class HomePageTest extends BaseTest {

    private HomePageObject homePage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePageObject(driver);
    }

    @Test(priority = 1, description = "Open home page successfully")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: Test demo for opening Shopee site")
    @Story("Open HomePage")
    public void testOpenHomePageSuccessfully() {
        Assert.assertEquals(homePage.getPageTitle(driver), "Shopee Việt Nam | Mua và Bán Trên Ứng Dụng Di Động Hoặc Website");
    }

    @Test(priority = 1, description = "Passed case template")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: Demo for passed case")
    @Story("Open HomePage")
    public void passedCaseTemplate() {
        Assert.assertTrue(true);
    }

    @Test(priority = 2, description = "Failed case template")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test description: Demo for failed case")
    @Story("Open HomePage")
    public void failedCaseTemplate() {
        Assert.assertEquals(homePage.getPageTitle(driver), "Shopee Việt Nam | Mua và Bán Trên Ứng Dụng Di Động Hoặc Website");
//        Assert.assertTrue(false);
    }
}
