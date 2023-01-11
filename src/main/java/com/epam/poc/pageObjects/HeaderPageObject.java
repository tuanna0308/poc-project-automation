package com.epam.poc.pageObjects;

import com.epam.poc.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.epam.poc.pageUIs.HeaderPageUI.ENGLISH_BUTTON_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.LANGUAGE_SELECTOR_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.LANGUAGE_SELECTOR_DROPDOWN_LIST_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.LOGIN_BUTTON_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.NOTIFICATION_BUTTON_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.NOTIFICATION_POP_OVER_TEXT_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.SHOPPING_CART_ICON_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.SHOPPING_CART_ICON_POP_OVER_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.SIGN_UP_BUTTON_BY;

import static com.epam.poc.pageUIs.HeaderPageUI.*;
import static com.epam.poc.pageUIs.SearchResultUI.FIRST_HISTORICAL_SUGGESTION_OPTION_CSS;
import static com.epam.poc.pageUIs.SearchResultUI.SEARCHBAR_LISTBOX_ID;

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

    @Step("Click search text box")
    public void clickSearchTextBox() {
        clickToElement(driver, By.cssSelector(SEARCH_TEXTBOX_CSS));
    }

    @Step("Clear value in search text box")
    public void clearSearchTextBox() {
        clearByKeys(driver, By.cssSelector(SEARCH_TEXTBOX_CSS));
    }

    @Step("Search by keyword '{0}'")
    public void searchByKeyword(String keyword) {
        sendKeyToElement(driver, By.cssSelector(SEARCH_TEXTBOX_CSS), keyword);
        clickToElement(driver, By.cssSelector(SEARCH_BUTTON_CSS));
    }

    @Step("Get text value in search text box")
    public String getTextSearchTextBox() {
        return getElementText(driver, By.cssSelector(FIRST_HISTORICAL_SUGGESTION_OPTION_CSS));
    }

    @Step("Verify search bar is displayed'")
    public boolean verifySearchBarIsDisplayed() {
        return isElementDisplayed(driver, By.id(SEARCHBAR_LISTBOX_ID));
    }

    @Step("Get notification element")
    public WebElement getNotificationElement() {
        WebElement notificationElement = driver.findElement(NOTIFICATION_BUTTON_BY);
        return notificationElement;
    }

    @Step("Get notification pop over text element")
    public WebElement getNotificationPopOverTextElement() {
        WebElement notificationPopOverText = driver.findElement(NOTIFICATION_POP_OVER_TEXT_BY);
        return notificationPopOverText;
    }

    @Step("Get language selector element")
    public WebElement getLanguageSelectorElement() {
        WebElement languageSelectorDropdownElement = driver.findElement(LANGUAGE_SELECTOR_BY);
        return languageSelectorDropdownElement;
    }

    @Step("Get language selector dropdown list")
    public List<WebElement> getLanguageSelectorDropdownList() {
        List<WebElement> dropdownList = driver.findElements(LANGUAGE_SELECTOR_DROPDOWN_LIST_BY);
        return dropdownList;
    }

    @Step("Get actual language selector dropdown list")
    public List<String> getActualLanguageSelectorDropdownList() {
        List<String> actualList = getLanguageSelectorDropdownList().stream()
                .map(e -> e.getAttribute("innerHTML"))
                .collect(Collectors.toList());
        return actualList;
    }

    @Step("Get sign up button element")
    public WebElement getSignUpButtonElement() {
        WebElement signUpButtonElement = driver.findElement(SIGN_UP_BUTTON_BY);
        return signUpButtonElement;
    }

    @Step("Get login button element")
    public WebElement getLoginButtonElement() {
        WebElement loginButtonElement = driver.findElement(LOGIN_BUTTON_BY);
        return loginButtonElement;
    }

    @Step("Get shopping cart icon element")
    public WebElement getShoppingCartIconElement() {
        return driver.findElement(SHOPPING_CART_ICON_BY);
    }

    @Step("Get shopping cart pop over element")
    public WebElement getShoppingCartPopOverElement() {
        WebElement shoppingCartPopOver = driver.findElement(SHOPPING_CART_ICON_POP_OVER_BY);
        return shoppingCartPopOver;
    }

    @Step("Get English button element")
    public WebElement getEnglishButtonElement() {
        return driver.findElement(ENGLISH_BUTTON_BY);
    }
}
