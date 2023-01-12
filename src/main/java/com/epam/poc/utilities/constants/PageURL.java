package com.epam.poc.utilities.constants;

public enum PageURL {
    HOME_PAGE_URL("https://shopee.vn/"),
    SEARCH_URL("search"),
    HELP_PAGE_URL("https://help.shopee.vn/portal"),
    SIGN_UP_PAGE_URL("https://shopee.vn/buyer/signup?next=https%3A%2F%2Fshopee.vn%2F"),
    LOGIN_PAGE_URL("https://shopee.vn/buyer/login?next=https%3A%2F%2Fshopee.vn%2F");

    private String url;
    PageURL(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
