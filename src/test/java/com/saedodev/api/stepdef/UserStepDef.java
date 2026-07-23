package com.saedodev.api.stepdef;

import com.saedodev.api.models.UserRequest;
import com.saedodev.api.utils.Apiclient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.saedodev.api.stepdef.CommonStepDef.response;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserStepDef {
    private String userId;

    @Given("User telah dibuat")
    public void user_created() {

        String email = "rin" + System.currentTimeMillis() + "@mail.com";

        UserRequest request = new UserRequest(
                "Rin",
                "Moriyama",
                email
        );

        response = Apiclient.createUser(request);
        System.out.println("Status Code : " + response.getStatusCode());

        userId = response.jsonPath().getString("id");

        assertNotNull(userId);
    }

    @When("User mengirim request Create User")
    public void create_user() {

        String email = "rin" + System.currentTimeMillis() + "@mail.com";

        UserRequest request = new UserRequest(
                "Rin",
                "Moriyama",
                email
        );

        response = Apiclient.createUser(request);

        userId = response.jsonPath().getString("id");
    }

    @And("Data user berhasil ditampilkan")
    public void verify_user_data() {

        assertEquals(userId, response.jsonPath().getString("id"));

    }

    @When("User mengirim request Get User berdasarkan ID")
    public void get_user() {

        response = Apiclient.getUser(userId);

    }

    @When("User mengirim request Update User")
    public void update_user() {

        UserRequest request = new UserRequest(
                "Chino",
                "Kafuu",
                "chino" + System.currentTimeMillis() + "@mail.com"
        );

        response = Apiclient.updateUser(userId, request);

    }

    @And("Data user berhasil diperbarui")
    public void verify_update_data() {

        assertEquals("Chino", response.jsonPath().getString("firstName"));
        assertEquals("Kafuu", response.jsonPath().getString("lastName"));

    }

    @When("User mengirim request Delete User")
    public void delete_user() {

        response = Apiclient.deleteUser(userId);

    }

    @And("User berhasil dihapus")
    public void verify_delete_user() {

        assertNotNull(userId);

    }

    @When("User mengirim request Get User dengan ID {string}")
    public void get_user_invalid(String id) {

        response = Apiclient.getUser(id);
        response.then().log().all();

    }

    @When("User mengirim request Update User dengan ID {string}")
    public void update_user_invalid(String id) {

        UserRequest request = new UserRequest(
                "saodjfhswiodfh",
                "osudfhosdfh",
                "isoudfhsiudf@mail.com"
        );

        response = Apiclient.updateUser(id, request);
        response.then().log().all();

    }

    @When("User mengirim request Delete User dengan ID {string}")
    public void delete_user_invalid(String id) {

        response = Apiclient.deleteUser(id);

    }

    @And("Response menampilkan pesan error")
    public void verify_invalid_user() {
        assertNotNull(response);
        assertNotNull(response.jsonPath().getString("error"));
    }

    @When("User mengirim request Create User tanpa First Name")
    public void blank_firstName() {

        String email = "rin" + System.currentTimeMillis() + "@mail.com";

        UserRequest request = new UserRequest(
                "",
                "Moriyama",
                email
        );

        response = Apiclient.createUser(request);

        userId = response.jsonPath().getString("id");
    }

    @When("User mengirim request Create User tanpa Last Name")
    public void blank_lastName() {

        String email = "rin" + System.currentTimeMillis() + "@mail.com";

        UserRequest request = new UserRequest(
                "",
                "Moriyama",
                email
        );

        response = Apiclient.createUser(request);

        userId = response.jsonPath().getString("id");
    }

    @And("Response menampilkan validasi error")
    public void validation_error() {
        assertNotNull(response);
        assertNotNull(response.jsonPath().getString("error"));
    }
}
