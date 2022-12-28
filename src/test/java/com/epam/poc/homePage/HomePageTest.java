package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import com.epam.poc.pageObjects.HeaderPageObject;
import com.epam.poc.pageUIs.CommonPageUI;
import com.epam.poc.pageUIs.HeaderPageUI;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
@Epic("Regression test")
@Feature("HomePage")
public class HomePageTest extends BaseTest {

    private HeaderPageObject headerPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePageObject(driver);
        headerPage = new HeaderPageObject(driver);

        homePage.closeHomePagePopup();
    }

    @Test
    @Description("Test description: Verify 'Home' button in any page ")
    @Story("Home Button")
    @Parameters({"pageUrl"})
    public void verifyHomeButtonInAnyPage(String pageUrl) {
        // Verify other page which has Home button
        headerPage.clickToElement(driver, By.cssSelector(HeaderPageUI.JOIN_AS_SELLER_HYPERLINK_CSS));
        String sellerTitleExpected = "Đăng Ký Bán Hàng Trên Shopee Ngay Hôm Nay - Hỗ Trợ Miễn Phí Cho Người Bán Mới";
        homePage.waitForPageTitleAsExpectedText(driver, sellerTitleExpected);
        Assert.assertEquals(homePage.getPageTitle(driver), sellerTitleExpected);
        String sellerUrlExpected = pageUrl + "m/dang-ky-ban-hang-shopee";
        Assert.assertEquals(homePage.getCurrentUrl(driver), sellerUrlExpected);

        // Verify Shoppe Home button
        homePage.clickToElement(driver, By.cssSelector(CommonPageUI.SHOPEE_LOGO_CSS));
        String homeTitleExpected = "Shopee Việt Nam | Mua và Bán Trên Ứng Dụng Di Động Hoặc Website";
        Assert.assertEquals(homePage.getPageTitle(driver), homeTitleExpected);
        Assert.assertEquals(homePage.getCurrentUrl(driver), pageUrl);
    }

    @Test
    @Description("Test description: Verify 'Home' button in Home page ")
    @Story("Home Button")
    @Parameters({"pageUrl"})
    public void verifyHomeButtonInHomePage(String pageUrl) {
        // Verify click on the Shopee logo
        homePage.clickToElement(driver, By.cssSelector(CommonPageUI.SHOPEE_LOGO_CSS));
        String homeTitleExpected = "Shopee Việt Nam | Mua và Bán Trên Ứng Dụng Di Động Hoặc Website";
        homePage.waitForPageTitleAsExpectedText(driver, homeTitleExpected);
        Assert.assertEquals(homePage.getPageTitle(driver), homeTitleExpected);
        Assert.assertEquals(homePage.getCurrentUrl(driver), pageUrl);
    }
}
