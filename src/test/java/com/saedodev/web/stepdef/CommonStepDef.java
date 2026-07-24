package com.saedodev.web.stepdef;

import com.saedodev.web.hooks.TestData;
import com.saedodev.web.pages.HomePage;
import com.saedodev.web.pages.LoginPage;
import com.saedodev.web.pages.SignupPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonStepDef {

    HomePage homePage = new HomePage();
    SignupPage signupPage = new SignupPage();
    LoginPage loginPage = new LoginPage();

    @Given("User berada di halaman utama Demoblaze")
    public void userHomePage() {

        assertTrue(homePage.getBrand());

    }
}
