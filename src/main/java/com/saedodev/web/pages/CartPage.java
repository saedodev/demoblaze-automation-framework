package com.saedodev.web.pages;

import com.saedodev.web.driver.DriverFactory;
import com.saedodev.web.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver = DriverFactory.getDriver();
    private WaitUtil wait = new WaitUtil(driver);
    public void deleteProduct(String productName) {

        By deleteButton = By.xpath(
                "//td[text()='" + productName + "']/following-sibling::td/a"
        );

        wait.waitUntilClickable(deleteButton).click();
    }

    public boolean isProductRemoved(String productName) {

        By product = By.xpath("//td[text()='" + productName + "']");

        return !wait.waitUntilInvisible(product);

    }


}
