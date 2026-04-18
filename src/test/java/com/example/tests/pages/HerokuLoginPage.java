package com.example.tests.pages;

import com.example.framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the demo login page: https://the-internet.herokuapp.com/login
 */
public class HerokuLoginPage extends BasePage {
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By flashMessage = By.id("flash");

    public HerokuLoginPage(WebDriver driver, int timeoutSeconds) {
        super(driver, timeoutSeconds);
    }

    public HerokuLoginPage open() {
        driver.get("https://the-internet.herokuapp.com/login");
        return this;
    }

    public SecureAreaPage login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
        return new SecureAreaPage(driver, timeoutSeconds());
    }

    public String flashText() {
        return waitVisible(flashMessage).getText();
    }
}

