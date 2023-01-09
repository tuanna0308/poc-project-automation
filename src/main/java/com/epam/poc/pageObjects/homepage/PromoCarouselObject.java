package com.epam.poc.pageObjects.homepage;

import com.epam.poc.commons.BasePage;
import com.epam.poc.pageUIs.homepage.PromoCarouselUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PromoCarouselObject extends BasePage {
    private final WebDriver driver;

    public PromoCarouselObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCarouselBannerByIndex(int index) {
        clickToElement(getCarouselDotByIndex(index - 1));
        clickToElement(getCarouselBannerByIndex(index));
        waitForPageLoadedCompletely(driver);
    }

    public void clickToBackwardArrowsByDotIndex(int index) {
        clickToElement(getCarouselDotByIndex(index));
        clickToElement(driver, By.className(PromoCarouselUI.BACK_ARROWS_CLASS));
    }

    public void clickToForwardArrowsByDotIndex(int index) {
        clickToElement(getCarouselDotByIndex(index));
        clickToElement(driver, By.className(PromoCarouselUI.FORWARD_ARROWS_CLASS));
    }

    public WebElement getCarouselDotByIndex(int index) {
        return getElements(driver, By.className(PromoCarouselUI.CAROUSEL_DOT_CLASS)).get(index);
    }

    public WebElement getCarouselBannerByIndex(int index) {
        return getElements(driver, By.className(PromoCarouselUI.BANNER_IMAGE_CLASS)).get(index);
    }

    public String getActiveCarouselHref() {
        return getElementAttribute(driver, By.xpath(PromoCarouselUI.CAROUSEL_ACTIVE_LINK_CSS_SELECTOR),"href");
    }

}
