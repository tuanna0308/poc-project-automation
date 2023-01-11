package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.HeaderPageObject;
import com.epam.poc.pageObjects.SearchResultObject;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.poc.pageUIs.HeaderPageUI.*;
import static com.epam.poc.pageUIs.SearchResultUI.*;

@Listeners({TestListener.class})
@Epic("Regression test")
@Feature("SearchFunctionality")
public class SearchFunctionalityTest extends BaseTest {

    private HeaderPageObject headerPage;
    private SearchResultObject searchResultPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePageObject(driver);
        headerPage = new HeaderPageObject(driver);
        searchResultPage = new SearchResultObject(driver);

        homePage.closeHomePagePopup();
    }

    @Test
    @Description("Test description: Verify search with keyword 'Túi xách'")
    @Story("Search Functionality")
    public void verifySearchKeywordTuiXach() {
        headerPage.sendKeyToElement(driver, By.cssSelector(SEARCH_TEXTBOX_CSS), "túi xách");
        headerPage.clickToElement(driver, By.cssSelector(SEARCH_BUTTON_CSS));

        String shopRelatedLabelExpected = "Shop liên quan đến \"túi xách\"";
        Assert.assertEquals(searchResultPage.getElementText(driver,
                By.cssSelector(SHOP_RELATED_LABEL_CSS)), shopRelatedLabelExpected);

        String searchResultLabelExpected = "Kết quả tìm kiếm cho từ khoá 'túi xách'";
        Assert.assertEquals(searchResultPage.getElementText(driver,
                By.cssSelector(SEARCH_RESULT_LABEL_CSS)), searchResultLabelExpected);

        Assert.assertEquals(searchResultPage.getElementText(driver,
                By.cssSelector(SORT_OPTION_SELECTED_BUTTON_CSS)), "Liên Quan");

        // ToDo: Implement later on feature "Product Card"

        searchResultPage.clickPaginationButtonByPageNumber("2");
        Assert.assertEquals(searchResultPage.getElementText(driver,
                By.cssSelector(SEARCH_RESULT_LABEL_CSS)), searchResultLabelExpected);
    }

    @Test
    @Description("Test description: Verify search with keyword 'thời trang thu đông cho bé'")
    @Story("Search Functionality")
    public void verifySearchKeywordQuanAoThuDongChoBe() {
        headerPage.sendKeyToElement(driver, By.cssSelector(SEARCH_TEXTBOX_CSS), "thời trang thu đông cho bé");
        headerPage.clickToElement(driver, By.cssSelector(SEARCH_BUTTON_CSS));

        String shopRelatedLabelExpected = "Shop liên quan đến \"thời trang thu đông cho bé\"";
        Assert.assertEquals(searchResultPage.getElementText(driver,
                By.cssSelector(SHOP_RELATED_LABEL_CSS)), shopRelatedLabelExpected);

        String searchResultLabelExpected = "Kết quả tìm kiếm cho từ khoá 'thời trang thu đông cho bé'";
        Assert.assertEquals(searchResultPage.getElementText(driver,
                By.cssSelector(SEARCH_RESULT_LABEL_CSS)), searchResultLabelExpected);

        Assert.assertEquals(searchResultPage.getElementText(driver,
                By.cssSelector(SORT_OPTION_SELECTED_BUTTON_CSS)), "Liên Quan");

        // ToDo: Implement later on feature "Product Card"

        searchResultPage.scrollThenClickToElement(driver, By.cssSelector(PAGINATION_RIGHT_BUTTON_CSS));
        Assert.assertEquals(searchResultPage.getElementText(driver,
                By.cssSelector(SEARCH_RESULT_LABEL_CSS)), searchResultLabelExpected);
    }

    @Test
    @Description("Test description: Verify historical suggestion")
    @Story("Search Functionality")
    public void verifyHistoricalSuggestion() {
        headerPage.clickToElement(driver, By.cssSelector(SEARCH_TEXTBOX_CSS));
        Assert.assertTrue(searchResultPage.isElementDisplayed(driver, By.id(SEARCHBAR_LISTBOX_ID)));

        headerPage.sendKeyToElement(driver, By.cssSelector(SEARCH_TEXTBOX_CSS), "túi xách");
        headerPage.clickToElement(driver, By.cssSelector(SEARCH_BUTTON_CSS));

        headerPage.clearByKeys(driver, By.cssSelector(SEARCH_TEXTBOX_CSS));
        headerPage.clickToElement(driver, By.cssSelector(SEARCH_TEXTBOX_CSS));
        Assert.assertEquals(searchResultPage.getElementText(driver,
                By.cssSelector(FIRST_HISTORICAL_SUGGESTION_OPTION_CSS)), "túi xách");
    }
}
