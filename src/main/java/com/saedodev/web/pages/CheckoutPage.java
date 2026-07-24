package com.saedodev.web.pages;

import com.saedodev.web.driver.DriverFactory;
import com.saedodev.web.utils.WaitUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver = DriverFactory.getDriver();
    private WaitUtil wait = new WaitUtil(driver);
    private final By nameReceipt = By.id("name");
    private final By creditCard = By.id("card");
    private final By btnCheckout = By.xpath("//button[text()='Place Order']");
    private final By btnPurchase = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    private final By purchaseSuccess = By.tagName("h2");

    public void inputName(String name) {
        WebElement element = wait.waitUntilVisible(nameReceipt);

        element.clear();

        wait.waitUntilVisible(nameReceipt).sendKeys(name);
    }

    public void inputCreditCard(String card) {

        WebElement element = wait.waitUntilVisible(nameReceipt);

        element.clear();
        wait.waitUntilVisible(creditCard).sendKeys(card);
    }

    public void checkOut() {
        wait.waitUntilClickable(btnCheckout).click();
    }
    public void purchase() { wait.waitUntilClickable(btnPurchase).click(); }

    public String getPurchaseMessage() {

        return wait.waitUntilVisible(purchaseSuccess)
                .getText();

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
