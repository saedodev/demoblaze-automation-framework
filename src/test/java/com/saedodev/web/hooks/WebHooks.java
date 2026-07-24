package com.saedodev.web.hooks;

import com.saedodev.web.driver.DriverFactory;
import com.saedodev.web.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebHooks {

    @Before(order = 0)
    public void setupWeb() {

        System.out.println("OPEN WEBSITE");
        System.out.println(ConfigReader.getBaseUrl());

        DriverFactory.getDriver().get(ConfigReader.getBaseUrl());
    }

    @Before(value = "@login", order = 1)
    public void prepareLoginUser() {

        System.out.println("REGISTER USER");

        UserHelper.ensureRegistered();
    }

    @After
    public void tearDown() {

        DriverFactory.quitDriver();

    }
}