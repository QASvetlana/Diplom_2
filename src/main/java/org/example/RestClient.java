package org.example;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;

public class RestClient {


    public static RequestSpecification getBaseSpec = with()
            .baseUri("https://stellarburgers.nomoreparties.site/")
            .contentType(ContentType.JSON);
    }

