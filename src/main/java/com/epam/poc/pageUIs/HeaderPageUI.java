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
    public static final By HELP_BUTTON_BY = By.cssSelector(".navbar__link--help");
    public static final By SIGN_UP_BUTTON_BY = By.cssSelector(".navbar__link--signup");
    public static final By LOGIN_BUTTON_BY = By.cssSelector(".navbar__link--login");
    public static final By SHOPPING_CART_ICON_BY = By.cssSelector(".icon-shopping-cart-2");
    public static final By SHOPPING_CART_ICON_POP_OVER_BY = By.cssSelector(".cart-drawer__popover");
    public static final By LANGUAGE_SELECTOR_BY = By.cssSelector("#stardust-popover0");
    public static final By LANGUAGE_SELECTOR_DROPDOWN_LIST_BY = By.cssSelector(".FD9KOo ._40RGqV span");
    public static final By VIETNAMESE_BUTTON_BY = By.cssSelector(".FD9KOo ._40RGqV:first-of-type");
    public static final By ENGLISH_BUTTON_BY = By.cssSelector(".FD9KOo ._40RGqV:last-of-type");
    public static final By NOTIFICATION_BUTTON_BY = By.cssSelector("#stardust-popover1");
    public static final By NOTIFICATION_POP_OVER_TEXT_BY = By.cssSelector(".KTqD8t");
}
