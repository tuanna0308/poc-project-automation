package com.epam.poc.pageUIs;

import org.openqa.selenium.By;

public class HeaderPageUI {

    public static final By FOLLOW_US_ON_FACEBOOK_LINK_BY = By.cssSelector("[title*='Facebook']");
    public static final By FOLLOW_US_ON_INSTAGRAM_LINK_BY = By.cssSelector("[title*='Instagram']");
    public static final By SELLER_CENTER_LINK_BY = By.cssSelector("a.ZUq1cc:first-of-type");
    public static final By JOIN_AS_SELLER_LINK_BY = By.cssSelector("a[href='https://shopee.vn/m/sell-on-shopee']");
    public static final By DOWNLOAD_LINK_BY = By.id("temporaryId");
    public static final By DOWNLOAD_QR_IMG_BY = By.cssSelector("[aria-describedby='temporaryId']");
    public static final String JOIN_AS_SELLER_HYPERLINK_CSS = "a[href='https://shopee.vn/m/sell-on-shopee']";
    public static final String SEARCH_TEXTBOX_CSS = "input.shopee-searchbar-input__input";
    public static final String SEARCH_BUTTON_CSS = "button.shopee-searchbar__search-button";
}
