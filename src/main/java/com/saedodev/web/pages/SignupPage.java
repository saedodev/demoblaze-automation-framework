package com.saedodev.web.pages;

import com.saedodev.web.driver.DriverFactory;
import com.saedodev.web.utils.WaitUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
    WebDriver driver = DriverFactory.getDriver();
    private WaitUtil wait = new WaitUtil(driver);
    private final By signUsername = By.id("sign-username");
    private final By signPassword = By.id("sign-password");
    private final By btnSignup    = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");

    public void registUsername(String username) {
        wait.waitUntilVisible(signUsername).sendKeys(username);
    }

    public void registPassword(String password) {
        wait.waitUntilVisible(signPassword).sendKeys(password);
    }

    public void clickSignup() {
        wait.waitUntilClickable(btnSignup).click();
    }

    public String getAlertMessage() {
        WebDriverWait wait = new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(10)
        );

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String message = alert.getText();
        alert.accept();

        return message;
    }
}
