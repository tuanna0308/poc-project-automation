package com.epam.poc.pageUIs;

public class SearchResultUI {
    public static final String SHOP_RELATED_LABEL_CSS = "div.shopee-header-section__header__title";
    public static final String SHOP_RELATED_CARD_ITEM_CSS = "div.shopee-search-user-item";
    public static final String SEARCH_RESULT_LABEL_CSS = "span.shopee-search-result-header__text";
    public static final String SORT_OPTION_SELECTED_BUTTON_CSS = "div.shopee-sort-by-options__option--selected";
    public static final String PAGINATION_LEFT_BUTTON_CSS = "button.shopee-icon-button--left";
    public static final String PAGINATION_RIGHT_BUTTON_CSS = "button.shopee-icon-button--right";
    public static final String SEARCHBAR_LISTBOX_ID = "shopee-searchbar-listbox";
    public static final String FIRST_HISTORICAL_SUGGESTION_OPTION_CSS = "a.shopee-searchbar-hints__history-entry:nth-child(2)";
    public static final String PRODUCT_CARD_TITLE_XPATH = "//div[@data-sqe='name']/div[contains(@class, 'FDn--+')]";
    public static String paginationButtonByPageNumberXpath(String pageNumber) {
        return "//button[text()=" + pageNumber + "]";
    }
}
