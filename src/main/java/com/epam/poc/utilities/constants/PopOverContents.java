package com.epam.poc.utilities.constants;

public enum PopOverContents {
    NOTIFICATION_POP_OVER_CONTENT("Đăng nhập để xem Thông báo"),
    SHOPPING_CART_POP_OVER_CONTENT("Chưa Có Sản Phẩm");

    public String content;

    PopOverContents(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
