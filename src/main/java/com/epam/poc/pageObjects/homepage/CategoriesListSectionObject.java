package com.epam.poc.pageObjects.homepage;

import com.epam.poc.commons.BasePage;
import com.epam.poc.utilities.RandomUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.poc.pageUIs.homepage.CategoriesListSectionUI.MAIN_CATEGORY_XPATH;
import static com.epam.poc.pageUIs.homepage.CategoriesListSectionUI.SUB_CATEGORY_XPATH;
import static com.epam.poc.pageUIs.homepage.CategoriesListSectionUI.INPUT_SEARCH_FIELD_XPATH;
import static com.epam.poc.pageUIs.homepage.CategoriesListSectionUI.SEARCHBAR_SELECTOR_XPATH;
import static com.epam.poc.pageUIs.homepage.CategoriesListSectionUI.SELECTED_CATEGORY_XPATH;
import static com.epam.poc.pageUIs.homepage.CategoriesListSectionUI.mainCategoryByIndex;
import static com.epam.poc.pageUIs.homepage.CategoriesListSectionUI.subCategoryByIndex;
import static com.epam.poc.pageUIs.homepage.CategoriesTilesSectionUI.MAIN_CATEGORY_CSS;

public class CategoriesListSectionObject extends BasePage {
    private final WebDriver driver;
    private final RandomUtil randomUtil;

    public CategoriesListSectionObject(WebDriver driver) {
        this.driver = driver;
        randomUtil = new RandomUtil();
    }

    @Step("Click a random category and get category name")
    public String clickRandomCategoryAndGetName(String categoryType) {
        By listElementLocator = categoryType.equals("main-category") ? By.xpath(MAIN_CATEGORY_XPATH)
                : By.xpath(SUB_CATEGORY_XPATH);
        waitForElementUntilVisible(driver, listElementLocator);
        List<WebElement> lstElement = driver.findElements(listElementLocator);
        int rand = randomUtil.getRandomNumberInBorder(lstElement.size() - 1) + 1;
        By randomElementLocator = categoryType.equals("main-category") ? By.xpath(mainCategoryByIndex(rand))
                : By.xpath(subCategoryByIndex(rand));
        String categoryText = getElementText(driver, randomElementLocator);
        scrollThenClickToElement(driver, randomElementLocator);
        return categoryText;
    }

    @Step("Wait for search field contains text then get placeholder")
    public String getSearchFieldPlaceholder(String text) {
        WebElement searchField = getElement(driver, By.xpath(INPUT_SEARCH_FIELD_XPATH));
        waitForElementContainsText(driver, searchField, text);
        return getElementAttribute(searchField, "placeholder");
    }

    @Step("Get search bar selector text")
    public String getSearchbarSelectorText() {
        return getElementText(driver, By.xpath(SEARCHBAR_SELECTOR_XPATH));
    }

    @Step("Get main category in categories list")
    public String getMainCategoryText() {
        return getElementText(driver, By.cssSelector(MAIN_CATEGORY_CSS));
    }

    @Step("Get current active sub category in categories list")
    public String getActiveCategoryText() {
        return getElementText(driver, By.xpath(SELECTED_CATEGORY_XPATH));
    }
}
