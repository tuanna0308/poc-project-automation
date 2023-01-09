package com.epam.poc.pageObjects.homepage;

import com.epam.poc.commons.BasePage;
import com.epam.poc.utilities.RandomUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.poc.pageUIs.homepage.CategoriesListSectionUI.*;
import static com.epam.poc.pageUIs.homepage.CategoriesListSectionUI.mainCategoryByIndex;

public class CategoriesListSectionObject extends BasePage {
    private final WebDriver driver;
    private final RandomUtil randomUtil;

    public CategoriesListSectionObject(WebDriver driver) {
        this.driver = driver;
        randomUtil = new RandomUtil();
    }

    @Step("Click a random category and get category name")
    public String clickRandomCategoryAndGetName(By by, String categoryType) {
        waitForElementUntilVisible(driver, by);
        List<WebElement> lstElement = driver.findElements(by);
        int rand = randomUtil.getRandomNumberInBorder(lstElement.size() - 1) + 1;
        By randomElement = categoryType.equals("main-category") ? By.xpath(mainCategoryByIndex(rand))
                : By.xpath(subCategoryByIndex(rand));
        String categoryText = getElementText(driver, randomElement);
        scrollThenClickToElement(driver, randomElement);
        return categoryText;
    }
}
