package com.saedodev.web.pages;

import com.saedodev.web.driver.DriverFactory;
import com.saedodev.web.utils.WaitUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver = DriverFactory.getDriver();
    private WaitUtil wait = new WaitUtil(driver);
    private final By signUsername = By.id("loginusername");
    private final By signPassword = By.id("loginpassword");
    private final By btnLogin     = By.xpath("//button[text()='Log in']");
    private final By welcomeUser  = By.id("nameofuser");

    public void loginUsername(String username) {
        wait.waitUntilVisible(signUsername).sendKeys(username);
    }

    public void loginPassword(String password) {
        wait.waitUntilVisible(signPassword).sendKeys(password);
    }

    public void clickLogin() {
        wait.waitUntilClickable(btnLogin).click();
    }

    public boolean isWelcomeUserDisplayed() {

        return wait.waitUntilVisible(welcomeUser).isDisplayed();

    }

    public String getWelcomeUser() {

        return wait.waitUntilVisible(welcomeUser).getText();

    }

    public void clearUsername() {
        wait.waitUntilVisible(signUsername).clear();
    }

    public void clearPassword() {
        wait.waitUntilVisible(signPassword).clear();
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
