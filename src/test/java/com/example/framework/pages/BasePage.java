package com.example.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Base class for Page Objects.
 * <p>
 * Encapsulates common, explicit-wait based interactions. Keeping waits here avoids copy/paste
 * across pages and makes tests less flaky.
 */
public abstract class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final int timeoutSeconds;

    protected BasePage(WebDriver driver, int timeoutSeconds) {
        this.driver = driver;
        this.timeoutSeconds = timeoutSeconds;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    }

    protected WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void type(By locator, String text) {
        WebElement el = waitVisible(locator);
        el.clear();
        el.sendKeys(text);
    }

    protected void click(By locator) {
        waitClickable(locator).click();
    }

    public String title() {
        return driver.getTitle();
    }

    public int timeoutSeconds() {
        return timeoutSeconds;
    }
}
