package com.saedodev.api.utils;

import com.saedodev.api.endpoints.endpoints;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Apiconfig {

    private static final String APP_ID = "63a804408eb0cb069b57e43a";

    private Apiconfig() {
    }

    public static RequestSpecification request() {

        RestAssured.baseURI = endpoints.BASE_URL;

        return RestAssured
                .given()
                .header("app-id", APP_ID)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json");
    }

}