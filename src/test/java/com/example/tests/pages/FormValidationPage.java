package com.example.tests.pages;

import com.example.framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for a form validation demo page.
 * Site: https://practice.expandtesting.com/form-validation
 */
public class FormValidationPage extends BasePage {
    private final By contactName = By.id("validationCustom01");
    private final By contactEmail = By.id("validationCustom02");
    private final By contactNumber = By.id("validationCustom03");
    private final By pickUpDate = By.id("validationCustom04");
    private final By paymentMethodCard = By.id("validationCustom05");
    private final By submitButton = By.cssSelector("button[type='submit']");
    private final By successAlert = By.cssSelector(".alert.alert-success");

    public FormValidationPage(WebDriver driver, int timeoutSeconds) {
        super(driver, timeoutSeconds);
    }

    public FormValidationPage open() {
        driver.get("https://practice.expandtesting.com/form-validation");
        return this;
    }

    public FormValidationPage submitEmpty() {
        click(submitButton);
        return this;
    }

    public FormValidationPage fillRequiredFields(String name, String email, String phone, String dateIso) {
        type(contactName, name);
        type(contactEmail, email);
        type(contactNumber, phone);
        type(pickUpDate, dateIso); // expects yyyy-mm-dd
        click(paymentMethodCard);
        return this;
    }

    public FormValidationPage submit() {
        click(submitButton);
        return this;
    }

    public boolean isSuccessVisible() {
        try {
            return waitVisible(successAlert).isDisplayed();
        } catch (Exception ignored) {
            return false;
        }
    }
}

