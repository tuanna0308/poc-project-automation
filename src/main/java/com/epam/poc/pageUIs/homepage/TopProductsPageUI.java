package com.epam.poc.pageUIs.homepage;

public class TopProductsPageUI {

    public static String TOP_PRODUCT_TITLE = "//div[contains(@class,'shopee-header-section--simple')] //span[contains(text(),'Tìm kiếm hàng đầu')]";
    public static String SEE_MORE_BUTTON = "//a[starts-with(@href, '/top_products?')]/button";
    public static String TOP_PRODUCT_LIST = "//li[@class='image-carousel__item']/a";
    public static String TOP_PRODUCT_ITEM_TAG = "//div/div[1]";
    public static String TOP_PRODUCT_ITEM_IMAGE = "//div //img";
    public static String TOP_PRODUCT_ITEM_SOLD_IN_MONTH = "//div/div[3]";
    public static String TOP_PRODUCT_ITEM_CATEGORY = "//div/following-sibling::div";
}