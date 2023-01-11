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

    @Step("Click on Pagination button by icon right")
    public void clickPaginationButtonByIconRight() {
        scrollThenClickToElement(driver, By.cssSelector(PAGINATION_RIGHT_BUTTON_CSS));
    }

    @Step("Get text of Shop Related label'")
    public String getTextShopRelatedLabel() {
        return getElementText(driver, By.cssSelector(SHOP_RELATED_LABEL_CSS));
    }

    @Step("Get text of Shop Related label'")
    public String getTextSearchResultLabel() {
        return getElementText(driver, By.cssSelector(SEARCH_RESULT_LABEL_CSS));
    }

    @Step("Get text of selected Sort option button'")
    public String getTextSelectedSortButton() {
        return getElementText(driver, By.cssSelector(SORT_OPTION_SELECTED_BUTTON_CSS));
    }
}
