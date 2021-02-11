package com.example;

public enum SwaggerApiEndpoints {
    GET_ALL_SERVERS("/api/gen/servers"),
    GET_ALL_CLIENTS("/api/gen/clients"),
    GET_SERVER_OPTIONS("/api/gen/servers/{framework}"),
    GET_CLIENT_OPTIONS("/api/gen/clients/{language}");

    private final String url;

    SwaggerApiEndpoints(String url) { this.url = url; }

    public String getUrl() { return url; }
}
