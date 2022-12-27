package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.CommonPageObject;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import com.epam.poc.pageObjects.HeaderPageObject;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
@Epic("Regression test")
@Feature("HomePage")
public class HomePageTest extends BaseTest {

    private HomePageObject homePage;
    private CommonPageObject commonPage;
    private HeaderPageObject headerPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePageObject(driver);
        headerPage = new HeaderPageObject(driver);
        commonPage = new CommonPageObject(driver);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: Verify 'Home' button in any page ")
    @Story("Home Button")
    @Parameters({"pageUrl"})
    public void verifyHomeButtonInAnyPage(String pageUrl) throws InterruptedException {
        // Need to close Ad popup after opened Home page.
        homePage.closeHomePagePopup();

        // Verify other page which has Home button
        headerPage.clickJoinAsSellerHyperlink();
        Thread.sleep(3000);
        String sellerTitleExpected = "Đăng Ký Bán Hàng Trên Shopee Ngay Hôm Nay - Hỗ Trợ Miễn Phí Cho Người Bán Mới";
        Assert.assertEquals(homePage.getPageTitle(driver), sellerTitleExpected);
        String sellerUrlExpected = pageUrl + "m/dang-ky-ban-hang-shopee";
        Assert.assertEquals(homePage.getCurrentUrl(driver), sellerUrlExpected);

        // Verify Shoppe Home button
        commonPage.clickShopeeLogo();
        String homeTitleExpected = "Shopee Việt Nam | Mua và Bán Trên Ứng Dụng Di Động Hoặc Website";
        Assert.assertEquals(homePage.getPageTitle(driver), homeTitleExpected);
        Assert.assertEquals(homePage.getCurrentUrl(driver), pageUrl);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: Verify 'Home' button in Home page ")
    @Story("Home Button")
    @Parameters({"pageUrl"})
    public void verifyHomeButtonInHomePage(String pageUrl) throws InterruptedException {
        // Need to close Ad popup after opened Home page.
        homePage.closeHomePagePopup();

        // Verify click on the Shopee logo
        commonPage.clickShopeeLogo();
        Thread.sleep(3000);
        String homeTitleExpected = "Shopee Việt Nam | Mua và Bán Trên Ứng Dụng Di Động Hoặc Website";
        Assert.assertEquals(homePage.getPageTitle(driver), homeTitleExpected);
        Assert.assertEquals(homePage.getCurrentUrl(driver), pageUrl);
    }
}
