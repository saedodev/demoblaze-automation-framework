package com.saedodev.web.stepdef;

import com.saedodev.web.hooks.TestData;
import com.saedodev.web.pages.HomePage;
import com.saedodev.web.pages.SignupPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignupStepDef {
    HomePage homePage = new HomePage();
    SignupPage signupPage = new SignupPage();

    @When("User membuka menu Sign Up")
    public void signupMenu() {

        homePage.clickSignup();
    }

    @And("User mengisi username baru")
    public void signUsername() {

        TestData.username = "rin" + System.currentTimeMillis();
        signupPage.registUsername(TestData.username);
    }

    @And("User mengisi password baru")
    public void signPassword() {

        signupPage.registPassword(TestData.password);
    }

    @And("User menekan tombol Sign Up")
    public void btnSignup() {

        signupPage.clickSignup();
    }

    @Then("Muncul alert Sign up successful.")
    public void alertSuccess() {

        String sucessMessage = signupPage.getAlertMessage();
        assertEquals("Sign up successful.", sucessMessage);
    }

    @And("User mengisi username yang sudah terdaftar")
    public void existingUsername() {

        signupPage.registUsername(TestData.username);
    }

    @And("User mengisi password")
    public void existedUsernamePassword() {

        signupPage.registPassword(TestData.password);
    }

    @Then("Muncul alert This user already exist.")
    public void alertExistUsername() {

        String existUsername = signupPage.getAlertMessage();
        assertEquals("This user already exist.", existUsername);
    }

    @When("User mengosongkan username")
    public void blankUsername() {

        signupPage.registUsername("");
    }

    @When("User mengosongkan password")
    public void blankPassword() {

        signupPage.registPassword("");
    }

    @Then("Muncul alert Please fill out Username and Password.")
    public void blankAlertUsername() {
        String existUsername = signupPage.getAlertMessage();
        assertEquals("Please fill out Username and Password.", existUsername);
    }

}
