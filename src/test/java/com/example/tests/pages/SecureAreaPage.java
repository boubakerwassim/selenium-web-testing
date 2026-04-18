package com.example.tests.pages;

import com.example.framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the secure area after successful login.
 */
public class SecureAreaPage extends BasePage {
    private final By header = By.cssSelector("div.example h2");
    private final By flashMessage = By.id("flash");

    public SecureAreaPage(WebDriver driver, int timeoutSeconds) {
        super(driver, timeoutSeconds);
    }

    public String headerText() {
        return waitVisible(header).getText();
    }

    public String flashText() {
        return waitVisible(flashMessage).getText();
    }
}

