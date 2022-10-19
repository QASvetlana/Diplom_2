import client.UserApiClient;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginApiTests {
    UserApiClient userApiClient = new UserApiClient();
    User user;
    String wrongEmail = "gkffh@hnnk.8f9";
    String wrongPassword = "qffyyuiiop";

    @Before
    public void createUser() {
        this.user = new User("hkfffkjd@hkn.Kl", "678fff9hbg", "Vlffff6");
        this.userApiClient.createUser(this.user);
    }

    @Test
    @DisplayName("login with existed user")
    public void loginExistedUserTest() {
        User user = new User(this.user.getEmail(), this.user.getPassword());
        Response response = this.userApiClient.loginUser(user);
        response.then().statusCode(200).and().body("success", equalTo(true));
    }

    @Test
    @DisplayName("login with wrong email")
    public void loginWithWrongEmail() {
        User user = new User(this.wrongEmail, this.user.getPassword());
        Response response = this.userApiClient.loginUser(user);
        response.then().statusCode(401).and().body("message", equalTo("email or password are incorrect"));
    }

    @Test
    @DisplayName("login with wrong password")
    public void loginWithWrongPassword() {
        User user = new User(this.user.getEmail(), this.wrongPassword);
        Response response = this.userApiClient.loginUser(user);
        response.then().statusCode(401).and().body("message", equalTo("email or password are incorrect"));
    }
}
