import client.CreateUserResponse;
import client.UserApiClient;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import models.User;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreateUserApiTest {
    UserApiClient userApiClient = new UserApiClient();
    User user;
    String accessToken;

    @After
    public void cleanUp() {
        this.userApiClient.deleteUser(this.accessToken);
    }

    @Test
    @DisplayName("create user test")
    public void createUserTest() {
        this.user = new User("ddver77vyt@hvl.Kv", "6vfvvbg", "Dgsv9");
        Response response = this.userApiClient.createUser(this.user);

        CreateUserResponse res = response.body().as(CreateUserResponse.class);

        response.then().body("success", equalTo(true));
        this.accessToken = res.accessToken;
    }

    @Test
    @DisplayName("create two same user")
    public void createTwoSameUser() {
        this.user = new User("vgv@bnvv.jv", "vvgvbskgf", "vvg77");
        Response response = this.userApiClient.createUser(this.user);
        CreateUserResponse res = response.body().as(CreateUserResponse.class);
        this.accessToken = res.accessToken;

        User sameUser = new User("Gvgvg@bnmv.jv", "78gkgf", "vgv7");
        Response response1 = this.userApiClient.createUser(sameUser);
        response1.then().statusCode(403).and().body("message", equalTo("User already exists"));
    }
}
