package api.utils;

import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AssertsUtil {

    public static void assertCodeAndJson(Response response, String jsonFileName, int statusCode){
        assertEquals(response.getStatusCode(),statusCode);
        assertThat(response.getBody().asString(), matchesJsonSchemaInClasspath(jsonFileName));
    }

    public static void assertStatusCode(Response response, int statusCode){
        assertEquals(response.getStatusCode(),statusCode);
    }
}
