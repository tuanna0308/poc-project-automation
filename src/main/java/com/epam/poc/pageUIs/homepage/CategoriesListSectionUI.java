package com.epam.poc.pageUIs.homepage;

public class CategoriesListSectionUI {
    public static final String MAIN_CATEGORY_XPATH = "//a[@class='jmj+AG']";
    public static final String SUB_CATEGORY_XPATH = "//a[@class='LYwNSg']";
    public static final String INPUT_SEARCH_FIELD_XPATH = "//form[@role='search']/input";
    public static final String SEARCHBAR_SELECTOR_XPATH = "//div[@class='shopee-searchbar-selector']";
    public static final String SELECTED_CATEGORY_XPATH = "//div[contains(@class,'shopee-category-list__sub-category-list')]//a[contains(@class,'active')]";

    public static String mainCategoryByIndex(int index) {
        return "(//a[@class='jmj+AG'])[" + index + "]";
    }

    public static String subCategoryByIndex(int index) {
        return "(//a[@class='LYwNSg'])[" + index + "]";
    }
}
