package com.epam.poc.pageObjects.homepage;

import com.epam.poc.commons.BasePage;
import com.epam.poc.pageUIs.homepage.PopularCategoriesMenuUI;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PopularCategoriesMenuObject extends BasePage {
    private final WebDriver driver;

    public PopularCategoriesMenuObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select category by index '{0}'")
    public void selectCategoryByIndex(int index) {
        clickToElementByIndex(getPopularCategories(), index);
    }

    @Step("Get list popular categories")
    public List<WebElement> getPopularCategories() {
        return getElements(driver, By.xpath(PopularCategoriesMenuUI.POPULAR_CATEGORIES_MENU_XPATH));
    }
}
