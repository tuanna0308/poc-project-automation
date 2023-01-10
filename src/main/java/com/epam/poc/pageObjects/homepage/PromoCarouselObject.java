package com.epam.poc.pageObjects.homepage;

import com.epam.poc.commons.BasePage;
import com.epam.poc.configs.browsers.BrowserName;
import com.epam.poc.pageUIs.homepage.PromoCarouselUI;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;


public class PromoCarouselObject extends BasePage {
    private final WebDriver driver;

    public PromoCarouselObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to carousel banner by index '{0}'")
    public PromoCarouselObject clickToCarouselBannerByIndex(int index) {
        clickToElement(getCarouselDotByIndex(index - 1));
        clickToElement(getCarouselBannerByIndex(index));
        waitForPageLoadedCompletely(driver);
        return this;
    }

    @Step("Click to backward arrows by dot index '{0}'")
    public PromoCarouselObject clickToBackwardArrowsByDotIndex(String browserName, int index) {
        clickToElement(getCarouselDotByIndex(index));
        if(BrowserName.valueOf(browserName.toUpperCase()) == BrowserName.FIREFOX) {
            hoverAndClickToElement(driver, By.className(PromoCarouselUI.BACK_ARROWS_CLASS));
        }
        clickToElement(driver, By.className(PromoCarouselUI.BACK_ARROWS_CLASS));
        return this;
    }
    @Step("Click to forward arrows by dot index '{0}'")
    public PromoCarouselObject clickToForwardArrowsByDotIndex(int index) {
        clickToElement(getCarouselDotByIndex(index));
        clickToElement(driver, By.className(PromoCarouselUI.FORWARD_ARROWS_CLASS));
        return this;
    }

    @Step("Get carousel dot by index '{0}'")
    public WebElement getCarouselDotByIndex(int index) {
        return getElements(driver, By.className(PromoCarouselUI.CAROUSEL_DOT_CLASS)).get(index);
    }

    @Step("Get carousel banner by index '{0}'")
    public WebElement getCarouselBannerByIndex(int index) {
        return getElements(driver, By.className(PromoCarouselUI.BANNER_IMAGE_CLASS)).get(index);
    }

    @Step("Get carousel banner href by index '{0}'")
    public String getCarouselBannerHrefPathByIndex(int index) {
        return getUrlPath(getElementAttribute(getCarouselBannerByIndex(index), "href"));
    }

}
