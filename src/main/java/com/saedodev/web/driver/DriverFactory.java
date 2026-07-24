package com.saedodev.web.driver;

import com.saedodev.web.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Incognito Mode
            options.addArguments("--incognito");

            // Disable Password Manager Popup
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            // Disable Automation Banner
            options.setExperimentalOption(
                    "excludeSwitches",
                    new String[]{"enable-automation"}
            );

            options.setExperimentalOption(
                    "useAutomationExtension",
                    false
            );

            // Jika dijalankan di GitHub Actions
            if (System.getenv("CI") != null) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
            }

            driver = new ChromeDriver(options);

            driver.manage()
                    .timeouts()
                    .implicitlyWait(Duration.ofSeconds(
                            ConfigReader.getImplicitWait()
                    ));

        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
