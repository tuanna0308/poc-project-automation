package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.HeaderPageObject;
import com.epam.poc.pageObjects.SearchResultObject;
import com.epam.poc.pageObjects.homepage.HomePageObject;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
        headerPage.searchByKeyword("túi xách");

        String shopRelatedLabelExpected = "Shop liên quan đến \"túi xách\"";
        Assert.assertEquals(searchResultPage.getTextShopRelatedLabel(), shopRelatedLabelExpected);

        String searchResultLabelExpected = "Kết quả tìm kiếm cho từ khoá 'túi xách'";
        Assert.assertEquals(searchResultPage.getTextSearchResultLabel(), searchResultLabelExpected);

        Assert.assertEquals(searchResultPage.getTextSelectedSortButton(), "Liên Quan");

        // ToDo: Implement later on feature "Product Card"

        searchResultPage.clickPaginationButtonByPageNumber("2");
        Assert.assertEquals(searchResultPage.getTextSearchResultLabel(), searchResultLabelExpected);
    }

    @Test
    @Description("Test description: Verify search with keyword 'thời trang thu đông cho bé'")
    @Story("Search Functionality")
    public void verifySearchKeywordQuanAoThuDongChoBe() {
        headerPage.searchByKeyword("thời trang thu đông cho bé");

        String shopRelatedLabelExpected = "Shop liên quan đến \"thời trang thu đông cho bé\"";
        Assert.assertEquals(searchResultPage.getTextShopRelatedLabel(), shopRelatedLabelExpected);

        String searchResultLabelExpected = "Kết quả tìm kiếm cho từ khoá 'thời trang thu đông cho bé'";
        Assert.assertEquals(searchResultPage.getTextSearchResultLabel(), searchResultLabelExpected);

        Assert.assertEquals(searchResultPage.getTextSelectedSortButton(), "Liên Quan");

        // ToDo: Implement later on feature "Product Card"

        searchResultPage.clickPaginationButtonByIconRight();
        Assert.assertEquals(searchResultPage.getTextSearchResultLabel(), searchResultLabelExpected);
    }

    @Test
    @Description("Test description: Verify historical suggestion")
    @Story("Search Functionality")
    public void verifyHistoricalSuggestion() {
        headerPage.clickSearchTextBox();
        Assert.assertTrue(headerPage.verifySearchBarIsDisplayed());

        headerPage.searchByKeyword("túi xách");

        headerPage.clearSearchTextBox();
        headerPage.clickSearchTextBox();
        Assert.assertEquals(headerPage.getTextSearchTextBox(), "túi xách");
    }
}
