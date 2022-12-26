package com.epam.poc.pageObjects.homepage;

import com.epam.poc.commons.BasePage;
import com.epam.poc.pageUIs.homepage.PopularCategoriesMenuUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopularCategoriesMenuObject extends BasePage {
    private final WebDriver driver;

    public PopularCategoriesMenuObject(WebDriver driver) {
        this.driver = driver;
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
