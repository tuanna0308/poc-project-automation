package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import com.epam.poc.pageObjects.homepage.PromoCarouselObject;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.*;
import org.testng.annotations.*;
import org.testng.Assert;

@Listeners({TestListener.class})
@Epic("Regression test")
@Feature("HomePage")
public class PromoCarouselTest extends BaseTest {
    private PromoCarouselObject promoCarousel;

    @BeforeMethod
    public void beforeMethod() {
        promoCarousel = new PromoCarouselObject(driver);
        homePage = new HomePageObject(driver);
        homePage.closeHomePagePopup();
    }

    @Test()
    @Description("Test description: Verify promo details page")
    @Story("Promo Carousel (dots)")
    @Parameters({"browserName"})
    public void verifyPromoDetailsPage() {
        int carouselIndex = 3;
        String expectedLink = promoCarousel.getCarouselBannerHrefPathByIndex(carouselIndex);
        promoCarousel.clickToCarouselBannerByIndex(carouselIndex);
        Assert.assertTrue(promoCarousel.getCurrentUrl(driver).contains(expectedLink));

    }

    @Test()
    @Description("Test description: Verify the navigation among promos")
    @Story("Promo Carousel (dots)")
    @Parameters({"browserName"})
    public void verifyTheNavigationAmongPromos(String browserName) {
        // Click Shoppe logo to back to homepage
        homePage.clickShopeeLogo().closeHomePagePopup();

        int carouselIndex = 3;
        String expectedLink = promoCarousel.getCarouselBannerHrefPathByIndex(carouselIndex);

        // Click on forward arrows to navigate to the next promo
        promoCarousel.clickToForwardArrowsByDotIndex(2)
                .clickToElement(promoCarousel.getCarouselBannerByIndex(carouselIndex));
        Assert.assertTrue(promoCarousel.getCurrentUrl(driver).contains(expectedLink));

        // Click Shoppe logo to back to homepage
        homePage.clickShopeeLogo().closeHomePagePopup();

        // Click on backward arrows to navigate to the previous promo
        promoCarousel.clickToBackwardArrowsByDotIndex(browserName, 3)
                .clickToElement(promoCarousel.getCarouselBannerByIndex(carouselIndex));
        Assert.assertTrue(promoCarousel.getCurrentUrl(driver).contains(expectedLink));
    }
}
