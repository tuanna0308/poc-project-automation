package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.HelpPageObject;
import com.epam.poc.pageObjects.LoginPageObject;
import com.epam.poc.pageObjects.SignUpPageObject;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import com.epam.poc.pageObjects.HeaderPageObject;
import com.epam.poc.utilities.constants.Languages;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.poc.commons.BasePage.goToHomePage;
import static com.epam.poc.pageUIs.HeaderPageUI.HELP_BUTTON_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.LANGUAGE_SELECTOR_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.LOGIN_BUTTON_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.NOTIFICATION_BUTTON_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.SHOPPING_CART_ICON_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.SIGN_UP_BUTTON_BY;
import static com.epam.poc.pageUIs.HeaderPageUI.VIETNAMESE_BUTTON_BY;
import static com.epam.poc.utilities.constants.PopOverContents.NOTIFICATION_POP_OVER_CONTENT;
import static com.epam.poc.utilities.constants.PopOverContents.SHOPPING_CART_POP_OVER_CONTENT;
import static com.epam.poc.utilities.constants.PageURL.HELP_PAGE_URL;
import static com.epam.poc.utilities.constants.PageURL.LOGIN_PAGE_URL;
import static com.epam.poc.utilities.constants.PageURL.SIGN_UP_PAGE_URL;

@Listeners({TestListener.class})
@Epic("Regression test")
@Feature("HomePage")
public class TopRightNavigationMenuTest extends BaseTest {

    private HeaderPageObject headerPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePageObject(driver);
        headerPage = new HeaderPageObject(driver);
        homePage.closeHomePagePopup();
    }

    @AfterMethod
    public void afterMethod() {
        goToHomePage(driver);
        homePage.closeHomePagePopup();
    }

    @Test
    @Description("TC-48: Verify notification hover action")
    @Story("Top right navigation menu")
    public void verifyNotificationHoverAction() {
        Assert.assertTrue(headerPage.getNotificationElement().isDisplayed());

        homePage.hoverElement(driver, NOTIFICATION_BUTTON_BY);
        Assert.assertTrue(headerPage.getNotificationElement().isDisplayed());
        Assert.assertTrue(headerPage.getNotificationPopOverTextElement().isDisplayed());
        Assert.assertEquals(headerPage.getNotificationPopOverTextElement().getText(),
                NOTIFICATION_POP_OVER_CONTENT.getContent());
    }

    @Test
    @Description("TC-56: Verify Help Page link on top right navigation menu")
    @Story("Top right navigation menu")
    public void verifyHelpPageLink() {
        homePage.clickToElement(driver, HELP_BUTTON_BY);
        helpPage = new HelpPageObject(driver);
        helpPage.waitForPageLoadedCompletely(driver);
        String currentUrl = helpPage.getNewTabUrl(driver);
        Assert.assertEquals(currentUrl, HELP_PAGE_URL.getUrl());
    }

    @Test
    @Description("TC-57: Verify Language selector dropdown list on top right navigation menu")
    @Story("Top right navigation menu")
    public void verifyLanguageSelectorDropdownList() {
        homePage.hoverElement(driver, LANGUAGE_SELECTOR_BY);
        headerPage.getLanguageSelectorDropdownList()
                .forEach(e -> Assert.assertTrue(e.isDisplayed()));
        Assert.assertEquals(headerPage.getActualLanguageSelectorDropdownList(), Languages.getLanguageList());

        homePage.clickToElement(driver, VIETNAMESE_BUTTON_BY);
        Assert.assertTrue(headerPage.getLanguageSelectorElement().isDisplayed());
        Assert.assertEquals(headerPage.getLanguageSelectorElement().getText(), "Tiếng Việt");
        Assert.assertTrue(headerPage.getSignUpButtonElement().isDisplayed());
        Assert.assertEquals(headerPage.getSignUpButtonElement().getText(), "Đăng Ký");
        Assert.assertTrue(headerPage.getLoginButtonElement().isDisplayed());
        Assert.assertEquals(headerPage.getLoginButtonElement().getText(), "Đăng Nhập");

        homePage.closeHomePagePopup();
        homePage.hoverElement(driver, LANGUAGE_SELECTOR_BY);
        homePage.clickToElement(headerPage.getEnglishButtonElement());
        Assert.assertTrue(headerPage.getLanguageSelectorElement().isDisplayed());
        Assert.assertEquals(headerPage.getLanguageSelectorElement().getText(), "English");
        Assert.assertTrue(headerPage.getSignUpButtonElement().isDisplayed());
        Assert.assertEquals(headerPage.getSignUpButtonElement().getText(), "Sign Up");
        Assert.assertTrue(headerPage.getLoginButtonElement().isDisplayed());
        Assert.assertEquals(headerPage.getLoginButtonElement().getText(), "Login");

        homePage.hoverElement(driver, LANGUAGE_SELECTOR_BY);
        homePage.clickToElement(driver, VIETNAMESE_BUTTON_BY);
    }




    @Test
    @Description("TC-58: Verify Sign Up link on top right navigation menu")
    @Story("Top right navigation menu")
    public void verifySignUpLink() {
        homePage.clickToElement(driver, SIGN_UP_BUTTON_BY);
        signUpPage = new SignUpPageObject(driver);
        signUpPage.waitForPageLoadedCompletely(driver);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, SIGN_UP_PAGE_URL.getUrl());
    }

    @Test
    @Description("TC-59: Verify Login link on top right navigation menu")
    @Story("Top right navigation menu")
    public void verifyLoginLink() {
        homePage.clickToElement(driver, LOGIN_BUTTON_BY);
        loginPage = new LoginPageObject(driver);
        loginPage.waitForPageLoadedCompletely(driver);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, LOGIN_PAGE_URL.getUrl());
    }

    @Test
    @Description("TC-60: Verify Shopping Cart icon link on top right navigation menu")
    @Story("Top right navigation menu")
    public void verifyShoppingCartIconLink() {
        homePage.hoverElement(driver, SHOPPING_CART_ICON_BY);
        Assert.assertTrue(headerPage.getShoppingCartPopOverElement().isDisplayed());
        Assert.assertEquals(headerPage.getShoppingCartPopOverElement().getText(), SHOPPING_CART_POP_OVER_CONTENT.getContent());

        homePage.clickToElement(headerPage.getShoppingCartIconElement());
        loginPage = new LoginPageObject(driver);
        loginPage.waitForPageLoadedCompletely(driver);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, LOGIN_PAGE_URL.getUrl());
    }
}
