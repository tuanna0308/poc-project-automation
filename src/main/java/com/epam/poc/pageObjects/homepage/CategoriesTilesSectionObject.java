package com.epam.poc.pageObjects.homepage;

import com.epam.poc.commons.BasePage;
import com.epam.poc.utilities.RandomUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.poc.pageUIs.homepage.CategoriesTilesSectionUI.*;


public class CategoriesTilesSectionObject extends BasePage {
    private final WebDriver driver;

    private final RandomUtil randomUtil = new RandomUtil();

    public CategoriesTilesSectionObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getRandomCategory() {
        List<WebElement> lstElement = getElements(driver, By.xpath(LIST_CATEGORY_HOMEPAGE_XPATH));
        return lstElement.get(randomUtil.getRandomNumberInBorder(lstElement.size()));
    }

    public void clickForwardButtonIfElementNotDisplay(WebElement element) {
        if (!element.isDisplayed()) {
            clickToElementByJS(driver, By.xpath(HOME_CATEGORY_LIST_FORWARD_ARROWS_XPATH));
        }
        waitForElementUntilVisible(driver, element);
    }

    public String getCategoryTextHomePage(WebElement element) {
        clickForwardButtonIfElementNotDisplay(element);
        return getElementText(element);
    }
}
