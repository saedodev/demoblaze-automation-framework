package com.saedodev.web.stepdef;

import com.saedodev.web.hooks.TestData;
import com.saedodev.web.pages.HomePage;
import com.saedodev.web.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDef {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @When("User membuka menu Log In")
    public void loginMenu() {

        homePage.clickLogin();

    }

    @And("User mengisi username yang valid")
    public void inputValidUsername() {

        loginPage.loginUsername(TestData.username);

    }

    @And("User mengisi password yang valid")
    public void inputValidPassword() {

        loginPage.loginPassword(TestData.password);

    }

    @And("User menekan tombol Log In")
    public void clickLoginButton() {

        loginPage.clickLogin();

    }

    @Then("Nama user ditampilkan pada navigation bar")
    public void loginSuccess() {

        assertTrue(loginPage.isWelcomeUserDisplayed());

        assertEquals(
                "Welcome " + TestData.username,
                loginPage.getWelcomeUser()
        );

    }

    @And("User mengisi password yang salah")
    public void wrongPassword() {

        loginPage.loginPassword("testwrongpass123");

    }

    @Then("Muncul alert Wrong password.")
    public void wrongPasswordAlert() {

        String message = loginPage.getAlertMessage();

        assertEquals("Wrong password.", message);

    }

    @And("User mengisi username yang tidak terdaftar")
    public void invalidUsername() {

        loginPage.loginUsername("rin_not_registered");

    }

    @Then("Muncul alert User does not exist.")
    public void userNotExistAlert() {

        String message = loginPage.getAlertMessage();

        assertEquals("User does not exist.", message);

    }

    @And("User login tanpa username")
    public void blankUsername() {

        loginPage.loginUsername("");

    }

    @And("User login tanpa password")
    public void blankPassword() {

        loginPage.loginPassword("");

    }

    @Then("Muncul alert Please fill out Username and Password. di menu login")
    public void blankLoginAlert() {

        String message = loginPage.getAlertMessage();

        assertEquals("Please fill out Username and Password.", message);

    }

}