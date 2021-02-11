package com.example.stepdefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BaseTest {

    public static String BASE_URI = "https://generator.swagger.io";

    public static final List<String> INVALID_CLIENT_SERVER_LIST =
            new ArrayList<>(Arrays.asList("123", "O2L5", "XXX"));

    public static final List<String> VALID_CLIENT_SERVER_LIST =
            new ArrayList<>(Arrays.asList("java", "go", "scala"));

    public String getRandomValidClientServer() {
        return VALID_CLIENT_SERVER_LIST.get(new Random().nextInt(VALID_CLIENT_SERVER_LIST.size()));
    }

    public String getRandomInvalidClientServer() {
        return INVALID_CLIENT_SERVER_LIST.get(new Random().nextInt(INVALID_CLIENT_SERVER_LIST.size()));
    }
}
