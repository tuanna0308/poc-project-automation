package com.epam.poc.homePage;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pageObjects.HomePageObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePageObject homePage;

    @BeforeClass
    public void beforeClass() {
        homePage = new HomePageObject(driver);
    }

    @Test
    public void testOpenHomePageSuccessfully() {
        Assert.assertEquals(homePage.getPageTitle(driver), "Shopee Việt Nam | Mua và Bán Trên Ứng Dụng Di Động Hoặc Website");
    }
}
