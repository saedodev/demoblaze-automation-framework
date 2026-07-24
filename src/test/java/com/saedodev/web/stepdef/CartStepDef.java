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

public class CartStepDef {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    @When("User menambahkan beberapa produk untuk cart")
    public void addAnotherProduct() {

        productPage.selectProduct(
                "Phone",
                "Iphone 6 32gb"
        );
        productPage.clickAddtoCart();
        assertEquals("Product added.", productPage.getAlertMessage());

        productPage.backToHome();

        productPage.selectProduct(
                "Laptop",
                "Sony vaio i5"
        );
        productPage.clickAddtoCart();
        assertEquals("Product added.", productPage.getAlertMessage());

        productPage.backToHome();

        productPage.selectProduct(
                "Monitor",
                "Apple monitor 24"
        );
        productPage.clickAddtoCart();
        assertEquals("Product added.", productPage.getAlertMessage());

    }

    @And("Produk tampil pada Cart")
    public void productAdded() {

        homePage.clickCart();

        assertTrue(homePage.isProductDisplayed("Iphone 6 32gb"));

        assertTrue(homePage.isProductDisplayed("Sony vaio i5"));
        assertTrue(homePage.isProductDisplayed("Apple monitor 24"));
    }

    @And("User menghapus produk")
    public void removeFromCart() {

        cartPage.deleteProduct("Iphone 6 32gb");
        cartPage.deleteProduct("Sony vaio i5");
        cartPage.deleteProduct("Apple monitor 24");
    }

    @Then("Produk berhasil dihapus")
    public void isProductRemoved() {

        assertTrue(cartPage.isProductRemoved("Iphone 6 32gb"));
        assertTrue(cartPage.isProductRemoved("Sony vaio i5"));
        assertTrue(cartPage.isProductRemoved("Apple monitor 24"));

    }
}
