package com.example.tests;

import com.example.framework.config.Config;
import com.example.framework.tests.BaseTest;
import com.example.tests.pages.GoogleHomePage;
import com.example.tests.pages.GoogleResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    @Test(description = "Verify Google search returns results")
    public void googleSearchReturnsResults() {
        int timeout = Config.defaultTimeoutSeconds();

        GoogleResultsPage results = new GoogleHomePage(driver, timeout)
                .open()
                .searchFor("Selenium WebDriver");

        Assert.assertTrue(results.hasAnyResults(), "Expected Google to show search results.");
    }
}

