package com.example.tests.pages;

import com.example.framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for Google results page.
 */
public class GoogleResultsPage extends BasePage {
    private final By resultsStats = By.id("result-stats");
    private final By resultLinks = By.cssSelector("a h3");

    public GoogleResultsPage(WebDriver driver, int timeoutSeconds) {
        super(driver, timeoutSeconds);
    }

    public boolean hasAnyResults() {
        // Google sometimes changes markup; we accept either stats visible or at least one result title.
        try {
            waitVisible(resultsStats);
            return true;
        } catch (Exception ignored) {
            return driver.findElements(resultLinks).size() > 0;
        }
    }
}

