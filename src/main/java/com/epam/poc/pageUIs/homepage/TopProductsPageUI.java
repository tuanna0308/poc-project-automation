package com.epam.poc.pageUIs.homepage;

public class TopProductsPageUI {

    public static String TOP_PRODUCT_TITLE = "//div[contains(@class,'shopee-header-section--simple')] //span[contains(text(),'Tìm kiếm hàng đầu')]";
    public static String SEE_MORE_BUTTON = "//a[starts-with(@href, '/top_products?')]/button";
    public static String TOP_PRODUCT_LIST = "//li[@class='image-carousel__item']/a";
    public static String TOP_PRODUCT_ITEM_TAG = "./div/div[1]";
    public static String TOP_PRODUCT_ITEM_IMAGE = "./div //img";
    public static String TOP_PRODUCT_ITEM_SOLD_IN_MONTH = "./div/div[3]";
    public static String TOP_PRODUCT_ITEM_CATEGORY_NAME = "./div/following-sibling::div";
    public static String TOP_PRODUCT_PAGE_TITLE = "//h1[normalize-space(text())='Tìm kiếm hàng đầu']";
    public static String FIRST_TOP_PRODUCT_TAB = "//li[contains(@class,'stardust-tabs-header__tab')][1]";
    public static String TOP_PRODUCT_BACK_ARROWS_XPATH = "(//div[contains(@class,'shopee-header-section--simple')]//div[contains(@class,'carousel-arrow') and .//*[contains(@class,'icon-arrow-left-bold')]])[4]";
    public static String TOP_PRODUCT_FORWARD_ARROWS_XPATH = "(//div[contains(@class,'shopee-header-section--simple')]//div[contains(@class,'carousel-arrow') and .//*[contains(@class,'icon-arrow-right-bold')]])[4]";
}