package com.saedodev.web.stepdef;

import com.saedodev.web.driver.DriverFactory;
import com.saedodev.web.pages.CartPage;
import com.saedodev.web.pages.HomePage;
import com.saedodev.web.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckoutStepDef {
    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();



}
