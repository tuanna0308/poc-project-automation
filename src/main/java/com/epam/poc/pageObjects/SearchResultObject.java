package com.epam.poc.pageObjects;

import com.epam.poc.commons.BasePage;
import com.epam.poc.pageUIs.SearchResultUI;
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

    @Step("Check whether '{1}' contains at least 1 word in '{0}' or not")
    public boolean isContainsKeyword(String keyword, String text) {
        boolean isContainsKeyword = false;
        String [] words = keyword.split(" ");

        for (String word: words ) {
            if(text.toLowerCase().contains(word.toLowerCase())) {
                isContainsKeyword = true;
                break;
            }
        }

        return isContainsKeyword;
    }

    @Step("Verify product card title contains keyword '{0}'")
    public boolean verifyProductCardTitleContainsKeyword(String keyword) {
        return isContainsKeyword(keyword, getElementText(driver,
                By.xpath(SearchResultUI.PRODUCT_CARD_TITLE_XPATH)));
    }
}
