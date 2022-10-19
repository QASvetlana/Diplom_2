package org.example;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserClient extends RestClient {

    private static final String USER_PATH = "api/auth/register";
    private static final String USER_LOGIN = "api/auth/login";

    public ValidatableResponse create(User user) {
        return given()
                .spec(getBaseSpec)
                .body(user)
                .when()
                .post(USER_PATH)
                .then();
    }

    public ValidatableResponse login(UserCredentials credentials) {
        return given()
                .spec(getBaseSpec)
                .body(credentials)
                .when()
                .post(USER_LOGIN)
                .then();
    }


}
