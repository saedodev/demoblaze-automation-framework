package com.saedodev.api.stepdef;

import com.saedodev.api.utils.Apiclient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

import static com.saedodev.api.stepdef.CommonStepDef.response;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TagStepDef {
        @When("User mengirim request Get List Tags")
        public void getTags() {

            response = Apiclient.getTags();
            response.then().log().all();
        }

        @And("List tag tidak kosong")
        public void noBlankTags() {

            List<String> tags = response.jsonPath().getList("data");

            assertNotNull(tags);
            assertFalse(tags.isEmpty());
        }
}
