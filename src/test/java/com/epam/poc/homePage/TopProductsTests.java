package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import com.epam.poc.pageObjects.homepage.TopProductsPageObject;
import com.epam.poc.pageUIs.homepage.TopProductsPageUI;
import com.epam.poc.utilities.constants.NavigationButtonType;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({TestListener.class})
@Epic("Regression test")
@Feature("HomePage")
public class TopProductsTests extends BaseTest {
    private TopProductsPageObject topProductsPO;
    int numberOfTopProductsPerSlide = 6;

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
    @Description("Verify See All in Top Products section in Homepage")
    @Story("Top Products section")
    public void verifyTopProductsSeeAllSection() {
        topProductsPO.clickSeeMoreButtonTopProducts();
        Assert.assertTrue(topProductsPO.validateTopProductPageTitleDisplay());
        Assert.assertTrue(topProductsPO.validateFirstTopProductTabActive());
    }

    @Test()
    @Description("Verify backward navigation")
    @Story("Top Products section")
    public void verifyBackwardNavigation() {
        List<WebElement> topProducts = topProductsPO.getTopProducts();
        topProductsPO.clickToAllNavigationButtonsByType(NavigationButtonType.FORWARD_ARROW);
        Assert.assertTrue(!topProductsPO.isElementDisplayed(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_FORWARD_ARROWS_XPATH)));
        for (int i = topProducts.size() - numberOfTopProductsPerSlide; i < topProducts.size(); i++) {
            Assert.assertTrue(topProducts.get(i).isDisplayed());
        }

        topProductsPO.clickToAllNavigationButtonsByType(NavigationButtonType.BACK_ARROW);
        Assert.assertTrue(!topProductsPO.isElementDisplayed(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_BACK_ARROWS_XPATH)));
        for (int i = 0; i < numberOfTopProductsPerSlide; i++) {
            Assert.assertTrue(topProducts.get(i).isDisplayed());
        }
    }

    @Test()
    @Description("Verify forward navigation")
    @Story("Top Products section")
    public void verifyForwardNavigation() {
        homePage.clickShopeeLogo().closeHomePagePopup().loadTopProductsSection();
        List<WebElement> topProducts = topProductsPO.getTopProducts();
        int numberOfForwardButtons = topProducts.size()/5 - 1;
        int startIndex = 0;

        for(int i = 0; i < numberOfForwardButtons; i++) {
            startIndex += numberOfTopProductsPerSlide - 1;
            int endIndex = startIndex + numberOfTopProductsPerSlide - 1;
            topProductsPO.clickNavigationButton(By.xpath(TopProductsPageUI.TOP_PRODUCT_FORWARD_ARROWS_XPATH));

            for (int j = startIndex; j < endIndex; j++) {
                Assert.assertTrue(topProducts.get(j).isDisplayed());
            }
        }
        Assert.assertTrue(!topProductsPO.isElementDisplayed(driver, By.xpath(TopProductsPageUI.TOP_PRODUCT_FORWARD_ARROWS_XPATH)));
    }
}