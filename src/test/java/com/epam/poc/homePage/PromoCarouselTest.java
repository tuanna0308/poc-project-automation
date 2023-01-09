package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import com.epam.poc.pageObjects.homepage.PromoCarouselObject;
import com.epam.poc.pageUIs.CommonPageUI;
import com.epam.poc.pageUIs.homepage.PromoCarouselUI;
import com.epam.poc.utilities.listeners.TestListener;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

@Listeners({TestListener.class})
@Title("Regression test")
@Features("HomePage")
public class PromoCarouselTest extends BaseTest {
    private PromoCarouselObject promoCarousel;

    @Parameters({"pageUrl"})
    @BeforeMethod
    public void beforeMethod(String pageUrl) {
        promoCarousel = new PromoCarouselObject(driver);
        homePage = new HomePageObject(driver);
        homePage.closeHomePagePopup();

    }

    @Test
    @Description("Test description: Verify promo details page")
    @Stories("Promo Carousel (dots)")
    public void verifyPromoDetailsPage() {
        int carouselIndex = 3;
        String expectedLink = promoCarousel.getElementAttribute(promoCarousel.getCarouselBannerByIndex(carouselIndex), "href");
        promoCarousel.clickToCarouselBannerByIndex(carouselIndex);
        Assert.assertEquals(promoCarousel.getCurrentUrl(driver), expectedLink);
    }

    @Test
    @Description("Test description: Verify the navigation among promos")
    @Stories("Promo Carousel (dots)")
    public void verifyTheNavigationAmongPromos() {
        // Click Shoppe logo to back to homepage
        homePage.clickShopeeLogo();
        homePage.closeHomePagePopup();

        int carouselIndex = 3;
        String expectedLink = promoCarousel.getElementAttribute(promoCarousel.getCarouselBannerByIndex(carouselIndex), "href");

        //Click on forward arrows to navigate to the next promo
        promoCarousel.clickToForwardArrowsByDotIndex(1);
        Assert.assertEquals(promoCarousel.getActiveCarouselHref(), expectedLink);

        //Click on backward arrows to navigate to the previous promo
        promoCarousel.clickToBackwardArrowsByDotIndex(3);
        Assert.assertEquals(promoCarousel.getActiveCarouselHref(), expectedLink);
    }
}
