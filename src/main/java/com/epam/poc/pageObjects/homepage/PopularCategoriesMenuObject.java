package com.epam.poc.pageObjects.homepage;

import com.epam.poc.commons.BasePage;
import com.epam.poc.pageUIs.homepage.PopularCategoriesMenuUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PopularCategoriesMenuObject extends BasePage {
    private final WebDriver driver;

    public PopularCategoriesMenuObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCategoryByIndex(int index) {
        waitForElementUntilClickable(driver, getPopularCategories().get(index));
        clickToElementByIndex(getPopularCategories(), index);
    }

    public List<WebElement> getPopularCategories() {
        return getElements(driver, By.xpath(PopularCategoriesMenuUI.POPULAR_CATEGORIES_MENU_XPATH));
    }

    public boolean isContainsKeyword(String keyword, String text) {
        boolean isContainsKeyword = false;
        String [] words = keyword.split(" ");

        for (String word: words ) {
            if(text.toLowerCase().contains(word.toLowerCase())) {
                isContainsKeyword = true;
            }
        }

        return isContainsKeyword;
    }
}
