package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import com.epam.poc.pageObjects.homepage.TopProductsPageObject;
import com.epam.poc.utilities.constants.NavigationButtonType;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

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
    @Description("#238 - Verify Top Products section in Homepage")
    @Story("Top Products section")
    public void verifyTopProductsSection() {
        Assert.assertTrue(topProductsPO.validateTopProductsSection());
    }

    @Test()
    @Description("Verify forward navigation")
    @Story("Top Products section")
    public void verifyForwardNavigation() {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> topProducts = topProductsPO.getTopProducts();
        topProductsPO.showNextTopProducts();
        softAssert.assertTrue(!topProducts.get(1).isDisplayed(),
                "The first Top Product is not displayed");
        topProductsPO.showAllTopProductsFromSide(NavigationButtonType.FORWARD_ARROW);
        softAssert.assertTrue(!topProductsPO.isShowNextTopProductsButtonDisappeared(),
                "The Next Top Products button is not displayed");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "verifyForwardNavigation", alwaysRun = true)
    @Description("Verify backward navigation")
    @Story("Top Products section")
    public void verifyBackwardNavigation() {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> topProducts = topProductsPO.getTopProducts();
        topProductsPO.showPreviousTopProducts();
        softAssert.assertTrue(!topProducts.get(topProducts.size()-1).isDisplayed(),
                "The last Top Product is not displayed");
        topProductsPO.showAllTopProductsFromSide(NavigationButtonType.BACK_ARROW);
        softAssert.assertTrue(!topProductsPO.isShowPreviousTopProductsButtonDisappeared(),
                "The Previous Top Products button is not displayed");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = { "verifyTopProductsSection", "verifyForwardNavigation", "verifyBackwardNavigation" }, alwaysRun = true )
    @Description("Verify See All in Top Products section in Homepage")
    @Story("Top Products section")
    public void verifyTopProductsSeeAllSection() {
        topProductsPO.clickSeeMoreButtonTopProducts();
        Assert.assertTrue(topProductsPO.validateTopProductPageTitleDisplay());
        Assert.assertTrue(topProductsPO.validateFirstTopProductTabActive());
    }
}