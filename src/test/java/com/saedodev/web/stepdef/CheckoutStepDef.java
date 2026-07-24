package com.saedodev.web.stepdef;

import com.saedodev.web.hooks.TestData;
import com.saedodev.web.pages.CheckoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CheckoutStepDef {

    CheckoutPage checkoutPage = new CheckoutPage();

    @When("User melakukan checkout dengan data valid")
    public void inputData() {

        checkoutPage.checkOut();

        checkoutPage.inputName(TestData.name);
        checkoutPage.inputCreditCard(TestData.creditCard);
    }

    @Then("Pesanan berhasil dibuat")
    public void successOrder() {
        checkoutPage.getPurchaseMessage();
    }

    @When("User melakukan checkout tanpa mengisi nama")
    public void blankName() {

        checkoutPage.checkOut();

        checkoutPage.inputName("");
        checkoutPage.inputCreditCard(TestData.creditCard);
        checkoutPage.purchase();
    }

    @When("User melakukan checkout tanpa mengisi kartu kredit")
    public void blankCreditCard() {

        checkoutPage.checkOut();

        checkoutPage.inputName(TestData.name);
        checkoutPage.inputCreditCard("");
        checkoutPage.purchase();
    }

    @Then("Muncul pesan error validasi")
    public void validationError() {
        String message = checkoutPage.getAlertMessage();

        assertEquals("Please fill out Name and Creditcard.", message);
    }

}
