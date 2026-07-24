package com.saedodev.api.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApiHooks {
    @Before("@api")
    public void setupApi() {
        System.out.println("===== API Test Started =====");
    }

    @After("@api")
    public void endApi() {
        System.out.println("===== API Test Finished =====");
    }
}
