package com.example.framework.driver;

import com.example.framework.config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

/**
 * Creates WebDriver instances.
 * <p>
 * This project uses WebDriverManager so you don't need to download or configure drivers manually.
 */
public final class DriverFactory {
    private DriverFactory() {
        // utility class
    }

    public static WebDriver createChromeDriver() {
        // In restricted environments (CI/sandboxes), the default WDM cache location might not be writable.
        // We redirect both the driver binaries cache and the resolution cache into the project directory.
        Path wdmDir = Path.of(System.getProperty("user.dir"), ".wdm");
        try {
            Files.createDirectories(wdmDir);
        } catch (Exception ignored) {
            // If we can't create it, WDM will fail later with a clear error.
        }
        System.setProperty("wdm.cachePath", wdmDir.toAbsolutePath().toString());
        System.setProperty("wdm.resolutionCachePath", wdmDir.toAbsolutePath().toString());

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        if (Config.headless()) {
            // "new" headless mode works better with recent Chrome versions.
            options.addArguments("--headless=new");
        }

        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1366,768");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        return driver;
    }
}
