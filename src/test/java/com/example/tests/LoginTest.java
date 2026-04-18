package com.example.tests;

import com.example.framework.config.Config;
import com.example.framework.tests.BaseTest;
import com.example.tests.pages.HerokuLoginPage;
import com.example.tests.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify login works on demo site")
    public void successfulLoginShowsSecureArea() {
        int timeout = Config.defaultTimeoutSeconds();

        SecureAreaPage secureArea = new HerokuLoginPage(driver, timeout)
                .open()
                .login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(secureArea.headerText().contains("Secure Area"), "Expected to land on Secure Area.");
        Assert.assertTrue(secureArea.flashText().contains("You logged into a secure area!"),
                "Expected a successful login flash message.");
    }
}

