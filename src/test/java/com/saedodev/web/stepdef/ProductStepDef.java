package com.saedodev.web.stepdef;

import com.saedodev.web.pages.HomePage;
import com.saedodev.web.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductStepDef {
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    @When("User memilih salah satu produk")
    public void getProduct() {

        productPage.openFirstProduct();
    }

    @Then("Detail produk berhasil ditampilkan")
    public void displayProduct() {

        productPage.isProductDisplayed();
    }

    @And("User menekan tombol Add to Cart")
    public void addToCart() {

        productPage.clickAddtoCart();
    }

    @Then("Produk berhasil ditambahkan ke cart")
    public void alertAddCart() {

        String message = productPage.getAlertMessage();

        assertEquals("Product added.", message);
    }

    @When("User menambahkan beberapa produk")
    public void addAnotherProduct() {
        productPage.selectProduct(
                "Monitor",
                "ASUS Full HD"
        );
        productPage.clickAddtoCart();
        assertEquals("Product added.", productPage.getAlertMessage());

        productPage.backToHome();

        productPage.selectProduct(
                "Laptop",
                "MacBook Pro"
        );
        productPage.clickAddtoCart();
        assertEquals("Product added.", productPage.getAlertMessage());


    }

    @Then("Semua produk berhasil masuk ke cart")
    public void productAdded() {
        homePage.clickCart();

        assertTrue(homePage.isProductDisplayed("ASUS Full HD"));

        assertTrue(homePage.isProductDisplayed("MacBook Pro"));
    }
}
