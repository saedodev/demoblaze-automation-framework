package com.saedodev.web.pages;

import com.saedodev.web.driver.DriverFactory;
import com.saedodev.web.utils.WaitUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver = DriverFactory.getDriver();
    private WaitUtil wait = new WaitUtil(driver);

    private final By firstProduct =
            By.cssSelector(".card-title a");

    private final By productName =
            By.cssSelector(".name");

    private final By addToCart =
            By.xpath("//a[text()='Add to cart']");

    private final By home =
            By.xpath("//a[text()='Home ']");

    public void openFirstProduct() {
        wait.waitUntilClickable(firstProduct).click();
    }

    public boolean isProductDisplayed() {
        return wait.waitUntilVisible(productName).isDisplayed();
    }

    public void clickAddtoCart() {
        wait.waitUntilClickable(addToCart).click();
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

    public void backToHome() {
        wait.waitUntilClickable(home).click();
    }

    public void selectProduct(String category, String productName) {

        HomePage homePage = new HomePage();
        switch (category.toLowerCase()) {

            case "phone":
                homePage.clickPhoneCategory();
                break;

            case "laptop":
                homePage.clickLaptopCategory();
                break;

            case "monitor":
                homePage.clickMonitorCategory();
                break;

            default:
                throw new IllegalArgumentException(
                        "Kategori tidak ditemukan : " + category
                );
        }

        By product = By.xpath("//a[text()='" + productName + "']");

        wait.waitUntilClickable(product).click();
    }
}
