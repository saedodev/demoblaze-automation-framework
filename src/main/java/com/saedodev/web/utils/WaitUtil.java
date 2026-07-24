package com.saedodev.web.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public WaitUtil(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(ConfigReader.getExplicitWait())
        );
    }

    public WebElement waitUntilVisible(By locator) {

        return wait.until(
                ExpectedConditions.refreshed(
                        ExpectedConditions.visibilityOfElementLocated(locator)
                )
        );
    }

    public WebElement waitUntilClickable(By locator) {

        return wait.until(
                ExpectedConditions.refreshed(
                        ExpectedConditions.elementToBeClickable(locator)
                )
        );
    }

    public void jsClick(By locator) {

        WebElement element = waitUntilVisible(locator);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    public boolean waitUntilInvisible(By locator) {
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }
}
