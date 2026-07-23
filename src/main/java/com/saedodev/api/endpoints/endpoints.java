package com.saedodev.api.endpoints;

public class endpoints {
    private endpoints() {
    }

    public static final String BASE_URL = "https://dummyapi.io/data/v1";

    public static final String CREATE_USER = "/user/create";

    public static final String GET_USER = "/user/{id}";

    public static final String UPDATE_USER = "/user/{id}";

    public static final String DELETE_USER = "/user/{id}";

    public static final String GET_TAGS = "/tag";
}
