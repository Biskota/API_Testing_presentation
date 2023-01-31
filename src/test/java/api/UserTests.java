package api;

import api.steps.UserSteps;
import api.utils.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static api.utils.AssertsUtil.*;
import static io.restassured.RestAssured.*;
import static properties.TestData.GET_USER_JSON;


public class UserTests extends BaseTest {

    private final UserSteps userSteps = new UserSteps();

    @Test
    public void post() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";

        Response response =
                given()
                        .header("accept", ContentType.JSON)
                        .header("Content-Type", ContentType.JSON)
                        .body("{\"id\": 0}")
                        .when()
                        .post("user")
                        .then()
                        .statusCode(200)
                        .extract().response();
        response.prettyPrint();
    }

    @Test
    public void createUser() {
        assertStatusCode(userSteps.userCreate(user), 200);
    }

    @Test
    public void getUser() {
        assertCodeAndJson(userSteps.getUser(user.getUsername()), GET_USER_JSON, 200);
    }
}
