package com.saedodev.web.hooks;

import com.saedodev.web.hooks.TestData;
import com.saedodev.web.pages.HomePage;
import com.saedodev.web.pages.SignupPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserHelper {
    private UserHelper() {
    }

    public static void ensureRegistered() {

        if (com.saedodev.web.hooks.TestData.isRegistered) {
            return;
        }

        HomePage homePage = new HomePage();
        SignupPage signupPage = new SignupPage();
        TestData testData = new TestData();

        homePage.clickSignup();

        TestData.username = "rin" + System.currentTimeMillis();

        signupPage.registUsername(TestData.username);
        signupPage.registPassword(TestData.password);

        signupPage.clickSignup();

        String message = signupPage.getAlertMessage();

        assertEquals("Sign up successful.", message);

        TestData.isRegistered = true;

        System.out.println("Registered User : " + TestData.username);
    }
}
