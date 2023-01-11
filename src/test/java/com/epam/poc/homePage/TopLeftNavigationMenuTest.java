package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.HeaderPageObject;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({TestListener.class})
@Epic("Regression test")
@Feature("HomePage")
public class TopLeftNavigationMenuTest extends BaseTest {
    private HeaderPageObject headerPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePageObject(driver);
        headerPage = new HeaderPageObject(driver);

        homePage.closeHomePagePopup();
    }

    @AfterMethod(onlyForGroups = "multipleWindowsHandling")
    public void closeNewTab(){
        headerPage.closeAndSwitchToPreviousTab();
    }

    @Test(groups = {"multipleWindowsHandling"})
    @Description("Test description: To verify 'Kênh người bán' ('Seller Center') link - not logged in")
    @Story("Top left navigation menu")
    public void verifySellerCenterLinkInHomePage() {
        headerPage.clickOnSellerCenterItem();
        Assert.assertEquals(homePage.getCurrentUrl(driver), "https://banhang.shopee.vn/account/signin?next=%2F");
    }

    @Test
    @Description("Test description: To verify 'Trở thành người bán Shopee' ('Join as Seller') link")
    @Story("Top left navigation menu")
    public void verifyJoinAsSellerLinkInHomePage() {
        headerPage.clickOnJoinAsSellerItem();
        Assert.assertEquals(homePage.getCurrentUrl(driver), "https://shopee.vn/m/dang-ky-ban-hang-shopee");
    }

    @Test(groups = {"multipleWindowsHandling"})
    @Description("Test description: To verify 'Kết nối Instagram' ('Follow us on Instagram') link")
    @Story("Top left navigation menu")
    public void verifyFollowUsOnInstagramLinkInHomePage() {
        headerPage.clickOnFollowUsOnInstagramItem();
        Assert.assertEquals(homePage.getCurrentUrl(driver), "https://www.instagram.com/Shopee_VN/");
    }

    @Test(groups = {"multipleWindowsHandling"})
    @Description("Test description: To verify 'Kết nối Facebook' ('Follow us on Facebook') link")
    @Story("Top left navigation menu")
    public void verifyFollowUsOnFacebookLinkInHomePage() {
        headerPage.clickOnFollowUsOnFacebookItem();
        Assert.assertEquals(homePage.getCurrentUrl(driver), "https://www.facebook.com/ShopeeVN");
    }

    @Test(groups = {"multipleWindowsHandling"})
    @Description("Test description: To verify 'Tải ứng dụng' (Download) item")
    @Story("Top left navigation menu")
    public void verifyDownloadItemInHomePage() {
        Assert.assertTrue(headerPage.hoverDownloadItem());
        headerPage.clickOnDownloadItem();
        Assert.assertEquals(homePage.getCurrentUrl(driver), "https://shopee.vn/web");
    }
}
