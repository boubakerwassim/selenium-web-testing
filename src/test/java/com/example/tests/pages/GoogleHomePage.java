package com.example.tests.pages;

import com.example.framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for Google homepage.
 */
public class GoogleHomePage extends BasePage {
    private final By searchBox = By.name("q");

    public GoogleHomePage(WebDriver driver, int timeoutSeconds) {
        super(driver, timeoutSeconds);
    }

    public GoogleHomePage open() {
        driver.get("https://www.google.com");
        return this;
    }

    public GoogleResultsPage searchFor(String query) {
        waitVisible(searchBox).sendKeys(query, Keys.ENTER);
        return new GoogleResultsPage(driver, timeoutSeconds());
    }
}
