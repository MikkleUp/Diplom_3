package tools;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserProvider {
    private static final String DELETE_USER = "/api/auth/user";
    private static final String USER_LOGIN = "/api/auth/login";
    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site";

    @Step("Take user's token")
    private static String getToken(String email, String password) {
        return given()
                .header("Content-type", "application/json")
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
                .post(USER_LOGIN)
                .then()
                .extract()
                .body()
                .path("accessToken")
                .toString().replaceAll("Bearer ", "");
    }

    @Step("Delete User")
    public static Response delete(String email, String password) {
        RestAssured.baseURI = BASE_URI;
        String bearerToken = getToken(email, password);
        return given()
                .header("Content-type", "application/json")
                .auth().oauth2(bearerToken)
                .delete(DELETE_USER);
    }
}