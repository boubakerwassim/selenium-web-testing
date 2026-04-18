package com.example.tests;

import com.example.framework.config.Config;
import com.example.framework.tests.BaseTest;
import com.example.tests.pages.FormValidationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class FormValidationTest extends BaseTest {

    @Test(description = "Verify form can be submitted when required fields are valid")
    public void validFormSubmissionShowsSuccess() {
        int timeout = Config.defaultTimeoutSeconds();

        String date = LocalDate.now().plusDays(3).toString(); // yyyy-mm-dd

        FormValidationPage page = new FormValidationPage(driver, timeout)
                .open()
                .fillRequiredFields("Test User", "test.user@example.com", "1234567890", date)
                .submit();

        Assert.assertTrue(page.isSuccessVisible(), "Expected a success message after submitting a valid form.");
    }
}

