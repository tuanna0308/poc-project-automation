package com.epam.poc.pageObjects;

import com.epam.poc.commons.BasePage;
import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.epam.poc.pageUIs.HeaderPageUI.LANGUAGE_SELECTOR_DROPDOWN_LIST_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.LOGIN_BUTTON_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.NOTIFICATION_SPAN_XPATH;
import static com.epam.poc.pageUIs.HeaderPageUI.NOTIFICATION_POP_OVER_TEXT_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.SHOPPING_CART_ICON_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.SHOPPING_CART_ICON_POP_OVER_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.SIGN_UP_BUTTON_BY;

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

    @Step("Get notification element")
    public WebElement getNotificationElement() {
        waitForElementUntilVisible(driver, NOTIFICATION_SPAN_XPATH);
        return getElement(driver, NOTIFICATION_SPAN_XPATH);
    }

    @Step("Get notification pop over text element")
    public WebElement getNotificationPopOverTextElement() {
        return getElement(driver, NOTIFICATION_POP_OVER_TEXT_BY);
    }

    @Step("Get language selector element")
    public WebElement getLanguageSelectorElement() {
        return getElement(driver, LANGUAGE_SELECTOR_BY);
    }

    @Step("Get language selector dropdown list")
    public List<WebElement> getLanguageSelectorDropdownList() {
        return getElements(driver, LANGUAGE_SELECTOR_DROPDOWN_LIST_BY);
    }

    @Step("Get actual language selector dropdown list")
    public List<String> getActualLanguageSelectorDropdownList() {
        return getLanguageSelectorDropdownList().stream()
                .map(e -> e.getAttribute("innerHTML"))
                .collect(Collectors.toList());
    }

    @Step("Get sign up button element")
    public WebElement getSignUpButtonElement() {
        return getElement(driver, SIGN_UP_BUTTON_BY);
    }

    @Step("Get login button element")
    public WebElement getLoginButtonElement() {
        return getElement(driver, LOGIN_BUTTON_BY);
    }

    @Step("Get shopping cart icon element")
    public WebElement getShoppingCartIconElement() {
        return getElement(driver, SHOPPING_CART_ICON_BY);
    }

    @Step("Get shopping cart pop over element")
    public WebElement getShoppingCartPopOverElement() {
        return getElement(driver, SHOPPING_CART_ICON_POP_OVER_BY);
    }

    @Step("Get shopping cart pop over element")
    public void waitAndHoverLanguage(By languageBy) {
        waitForElementUntilVisible(driver, languageBy);
        hoverElement(driver, languageBy);
    }

}
