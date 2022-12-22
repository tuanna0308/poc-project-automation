package com.epam.poc.pageObjects.homepage;

import com.epam.poc.commons.BasePage;
import com.epam.poc.pageUis.homepage.PopularCategoriesMenuUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PopularCategoriesMenuObject extends BasePage {
    private final WebDriver driver;

    public PopularCategoriesMenuObject(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getPopularCategoryElements() {
        return driver.findElements(By.xpath(PopularCategoriesMenuUI.POPULAR_CATEGORIES_MENU_XPATH));
    }

    public void clickToPopularCategoryByIndex(int index) {
        List<WebElement> popularCategoryElements = getPopularCategoryElements();
        popularCategoryElements.get(index).isEnabled();
        popularCategoryElements.get(index).click();
    }

    public String getTextPopularCategoryByIndex(int index) {
        List<WebElement> popularCategoryElements = getPopularCategoryElements();
        return popularCategoryElements.get(index).getText();
    }

    public String getShopSearchResultLabel() {
        return driver.findElement(By.className(PopularCategoriesMenuUI.SHOPEE_SHOP_SEARCH_RESULT_LABEL_CLASS_NAME)).getText();
    }

    public String getProductSearchResultLabel() {
        return driver.findElement(By.className(PopularCategoriesMenuUI.SHOPEE_PRODUCT_SEARCH_RESULT_LABEL_CLASS_NAME)).getText();
    }

    public boolean isShopSearchResultCardItemDisplayed() {
        WebElement shopSearchResultCardItem = driver.findElement(By.className(PopularCategoriesMenuUI.SHOPEE_SHOP_SEARCH_RESULT_CARD_ITEM_CLASS_NAME));
        if(shopSearchResultCardItem.isDisplayed()) {
            return true;
        }

        return false;
    }

    public List<WebElement> getProductCards() {
        return driver.findElements(By.className(PopularCategoriesMenuUI.PRODUCT_CARDS_CLASS_NAME));
    }

    public String getSearchInputValue() {
        return driver.findElement(By.xpath(PopularCategoriesMenuUI.SEARCH_INPUT_XPATH)).getAttribute("value").toLowerCase();
    }
    public String getProductCardTitle() {
        return driver.findElement(By.xpath(PopularCategoriesMenuUI.PRODUCT_CARD_TITLE_XPATH)).getText();
    }

    public String getProductCardTitleByCard(WebElement element) {
        return element.findElement(By.xpath(PopularCategoriesMenuUI.PRODUCT_CARD_TITLE_XPATH)).getText();
    }

    public boolean isContainsKeyword(String keyword, String string) {
        boolean isContainsKeyword = false;
        String [] words = keyword.split(" ");

        for (String word: words ) {
            if(string.contains(word)) {
                isContainsKeyword = true;
            }
        }

        return isContainsKeyword;
    }
}
