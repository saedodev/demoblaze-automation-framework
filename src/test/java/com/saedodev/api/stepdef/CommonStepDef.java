package com.saedodev.api.stepdef;

import com.saedodev.api.utils.Schemareader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CommonStepDef {
    public static Response response;

    @Given("Dummy API tersedia")
    public void dummy_api() {
        //
    }

    @Then("Status code harus {int}")
    public void status_code(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("Response sesuai user schema")
    public void valid_userschema() {
        Schemareader.validate(response, "user-schema.json");
    }

    @Then("Response sesuai tag schema")
    public void valid_tagschema() {
        Schemareader.validate(response, "tag-schema.json");
    }
}
