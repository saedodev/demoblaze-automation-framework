package com.saedodev.web.stepdef;

import com.saedodev.web.driver.DriverFactory;
import com.saedodev.web.hooks.TestData;
import com.saedodev.web.pages.HomePage;
import com.saedodev.web.pages.LoginPage;
import com.saedodev.web.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDef {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @When("User membuka menu Log In")
    public void loginMenu() {
        WebDriver driver = DriverFactory.getDriver();

        driver.get(ConfigReader.getBaseUrl());

        System.out.println("URL      : " + driver.getCurrentUrl());
        System.out.println("TITLE    : " + driver.getTitle());
        System.out.println("LOGIN2   : " + driver.findElements(By.id("login2")).size());

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