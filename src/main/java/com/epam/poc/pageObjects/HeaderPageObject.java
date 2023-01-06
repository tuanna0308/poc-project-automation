package com.epam.poc.pageObjects;

import com.epam.poc.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static com.epam.poc.pageUIs.HeaderPageUI.*;

public class HeaderPageObject extends BasePage {
    private final WebDriver driver;

    public HeaderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Go to Sell Center page from top left menu header")
    public void clickOnSellerCenterItem() {
        clickToElement(driver, SELLER_CENTER_LINK_BY);
        switchToLastTab(driver);
        waitForPageTitleAsExpectedText(driver, "Đăng Ký Bán Hàng Trên Shopee Ngay Hôm Nay - Hỗ Trợ Miễn Phí Cho Người Bán Mới");
    }

    @Step("Go to Join as Seller page from top left menu header")
    public void clickOnJoinAsSellerItem() {
        clickToElement(driver, JOIN_AS_SELLER_LINK_BY);
        waitForPageTitleAsExpectedText(driver, "Shopee - Kênh Người Bán");
    }

    @Step("Go to Follow us on Facebook page from top left menu header")
    public void clickOnFollowUsOnFacebookItem() {
        clickToElement(driver, FOLLOW_US_ON_FACEBOOK_LINK_BY);
        switchToLastTab(driver);
        waitForPageLoadedCompletely(driver);
    }

    @Step("Go to Follow us on Instagram page from top left menu header")
    public void clickOnFollowUsOnInstagramItem() {
        clickToElement(driver, FOLLOW_US_ON_INSTAGRAM_LINK_BY);
        switchToLastTab(driver);
        waitForPageLoadedCompletely(driver);
    }

    @Step("Go to Download page from top left menu header")
    public void clickOnDownloadItem() {
        clickToElement(driver, DOWNLOAD_LINK_BY);
        switchToLastTab(driver);
        waitForPageLoadedCompletely(driver);
    }

    @Step("verify QR code from Top left menu header")
    public boolean hoverDownloadItem() {
        hoverElement(driver, DOWNLOAD_LINK_BY);
        return isElementDisplayed(driver, DOWNLOAD_QR_IMG_BY);
    }

    @Step("Close Tab and back the previous tab")
    public void closeAndSwitchToPreviousTab() {
        closeCurrentTab(driver);
        switchToFirstTab(driver);
    }
}
