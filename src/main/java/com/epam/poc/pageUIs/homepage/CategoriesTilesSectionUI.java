package com.epam.poc.pageUIs.homepage;

public class CategoriesTilesSectionUI {
    public static final String MAIN_CATEGORY_CSS = ".shopee-category-list__main-category__link";
    public static final String SEARCH_ITEMS_CSS = ".shopee-search-item-result__item";
    public static final String PRODUCT_SPECIFICATIONS_CATEGORY_XPATH = "//div[contains(@class,'product-detail page-product__detail')]//a[text()='Shopee']//following-sibling::a[1]";
    public static final String LIST_CATEGORY_HOMEPAGE_XPATH = "//div[@class='home-category-list']//a[@class='home-category-list__category-grid']";
    public static final String LAST_CATEGORY_HOMEPAGE_XPATH = "(//div[@class='home-category-list']//a[@class='home-category-list__category-grid'])[last()]";
    public static final String FIRST_CATEGORY_HOMEPAGE_XPATH = "(//div[@class='home-category-list']//a[@class='home-category-list__category-grid'])[1]";
    public static final String HOME_CATEGORY_LIST_BACK_ARROWS_XPATH = "//div[contains(@class,'home-category-list')]//div[contains(@class,'carousel-arrow') and .//*[contains(@class,'icon-arrow-left-bold')]]";
    public static final String HOME_CATEGORY_LIST_FORWARD_ARROWS_XPATH = "//div[contains(@class,'home-category-list')]//div[contains(@class,'carousel-arrow') and .//*[contains(@class,'icon-arrow-right-bold')]]";
    public static final String SHOPEE_ICON_CSS = ".header-with-search__logo-section";

    public static String searchItemByIndexCss(int index) {
        return ".shopee-search-item-result__item:nth-child(" + index + ")";
    }
}
