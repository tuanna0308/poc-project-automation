package com.epam.poc.pageObjects;

import com.epam.poc.commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.epam.poc.pageUIs.SearchResultUI.*;

public class SearchResultObject extends BasePage {

    private final WebDriver driver;

    public SearchResultObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on Pagination button by page number '{0}'")
    public void clickPaginationButtonByPageNumber(String pageNumber) {
        scrollThenClickToElement(driver, By.xpath(paginationButtonByPageNumberXpath(pageNumber)));
    }
}
