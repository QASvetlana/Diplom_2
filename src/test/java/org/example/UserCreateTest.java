package org.example;

import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import java.rmi.activation.ActivationGroup_Stub;

import static junit.framework.TestCase.assertEquals;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

public class UserCreateTest {
    // подготовили юзера
    private User user;
    // подготовили клиента, который может дергать эндпоинты
    private UserClient userClient;

    @Before
    public void setUp() {
        user = UserGenerator.getDefault();
        userClient = new UserClient();
    }

    @Test
    public void userCanBeCreatedTest() {
        //дернули эндпоинт
        ValidatableResponse response = userClient.create(user);
        // вытащили статус код из ответа
        int statusCode = response.extract().statusCode();
        assertEquals(SC_OK, statusCode);
        ValidatableResponse loginResponse = userClient.login(UserCredentials.from(user));
        int loginStatusCode = loginResponse.extract().statusCode();
        assertEquals(SC_OK, loginStatusCode);


    }

}
