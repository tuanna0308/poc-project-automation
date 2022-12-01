package com.epam.poc.tests;

import com.epam.poc.commons.BaseTest;
import com.epam.poc.pages.TemplatePage;
import com.epam.poc.utilities.listeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({ TestListener.class })
@Epic("Smoke test")
@Feature("Test template")
public class TestTemplate extends BaseTest {
    @Test(priority = 0, description="Passed case template")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: Demo for passed case")
    @Story("Story template")
    public void passedCaseTemplate() {
        Assert.assertEquals(true, true);
    }

    @Test(priority = 0, description="Failed case template")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test description: Demo for failed case")
    @Story("Story template")
    public void failedCaseTemplate() {
        TemplatePage templatePage = new TemplatePage(driver);
        templatePage.failedCaseTemplate();
        Assert.assertEquals(true, false);
    }

}