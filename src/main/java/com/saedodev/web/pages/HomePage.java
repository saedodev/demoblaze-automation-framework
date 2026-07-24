package com.saedodev.web.pages;

import com.saedodev.web.driver.DriverFactory;
import com.saedodev.web.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver = DriverFactory.getDriver();
    private WaitUtil wait = new WaitUtil(driver);

    private final By brand = By.id("nava");
    private final By signup = By.id("signin2");
    private final By login = By.id("login2");
    private final By cart = By.id("cartur");
    private final By phoneCategory =
            By.xpath("//a[text()='Phones']");

    private final By laptopCategory =
            By.xpath("//a[text()='Laptops']");

    private final By monitorCategory =
            By.xpath("//a[text()='Monitors']");

    public boolean getBrand() {
        return wait.waitUntilVisible(brand).isDisplayed();
    }

    public void clickSignup() {
        wait.jsClick(signup);
    }

    public void clickLogin() {
        wait.jsClick(login);
    }

    public void clickCart() {
        wait.jsClick(cart);
    }

    public void clickPhoneCategory() {
        wait.waitUntilClickable(phoneCategory).click();
    }

    public void clickLaptopCategory() {
        wait.waitUntilClickable(laptopCategory).click();
    }

    public void clickMonitorCategory() {
        wait.waitUntilClickable(monitorCategory).click();
    }

    public void selectProduct(String productName) {

        By product =
                By.xpath("//a[text()='" + productName + "']");

        wait.waitUntilClickable(product).click();
    }
}
