package com.saedodev.api.utils;

import com.saedodev.api.endpoints.endpoints;
import com.saedodev.api.models.UserRequest;
import io.restassured.response.Response;

public class Apiclient {
    private Apiclient() {

    }

    public static Response createUser(UserRequest body) {
        return Apiconfig.request()
                .body(body)
                .post(endpoints.CREATE_USER);
    }

    public static Response getUser(String id) {
        return Apiconfig.request()
                .pathParam("id", id)
                .get(endpoints.GET_USER);
    }

    public static Response updateUser(String id, UserRequest body) {
        return Apiconfig.request()
                .pathParam("id", id)
                .body(body)
                .put(endpoints.UPDATE_USER);
    }

    public static Response deleteUser(String id) {
        return Apiconfig.request()
                .pathParam("id", id)
                .delete(endpoints.DELETE_USER);
    }

    public static Response getTags() {
        return Apiconfig.request()
                .get(endpoints.GET_TAGS);
    }
}
