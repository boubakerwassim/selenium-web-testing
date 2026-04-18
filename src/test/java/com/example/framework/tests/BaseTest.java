package com.example.framework.tests;

import com.example.framework.config.Config;
import com.example.framework.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * Base test class that manages WebDriver lifecycle.
 * <p>
 * Keeping setup/teardown in one place provides consistent, reliable behavior across all tests.
 */
public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"baseUrl"})
    public void setUp(@Optional String baseUrlFromXml) {
        driver = DriverFactory.createChromeDriver();

        // baseUrl can come from:
        // - testng.xml parameter
        // - system property (-DbaseUrl=...)
        // - env var (baseUrl)
        // - default value in Config
        String baseUrl = (baseUrlFromXml != null && !baseUrlFromXml.isBlank())
                ? baseUrlFromXml
                : Config.baseUrl();

        driver.get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
