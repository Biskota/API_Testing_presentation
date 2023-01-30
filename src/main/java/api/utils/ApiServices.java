package api.utils;

import com.github.viclovsky.swagger.coverage.SwaggerCoverageRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static api.utils.Base.testProp;

public class ApiServices {

    public static Response postRequest(String endpoint, Map<String, Object> headers, Object body, Map<String, String> queryParams, Map<String, String> pathParams) {
        RequestSpecification requestSpecification = RestAssured.given().filter(new SwaggerCoverageRestAssured());

        if (headers != null)
            for (Map.Entry<String, Object> header : headers.entrySet()) {
                requestSpecification.header(header.getKey(), header.getValue());
            }
        if (pathParams != null)
            for (Map.Entry<String, String> pathParam : pathParams.entrySet()) {
                requestSpecification.pathParam(pathParam.getKey(), pathParam.getValue());
            }
        if (queryParams != null)
            for (Map.Entry<String, String> queryParam : queryParams.entrySet()) {
                requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
            }

        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);

        if (body != null) {
            requestSpecification.body(body);
        }

        if (testProp.consoleLog()) {
            requestSpecification.then()
                    .log()
                    .all();
        }

        Response resp = requestSpecification.post(testProp.BASE_URL() + endpoint);


        return resp;
    }

    public static Response getRequest(String endpoint, Map<String, Object> headers, Object body, Map<String, Object> queryParams, Map<String, String> pathParams) {
        RequestSpecification requestSpecification = RestAssured.given().filter(new SwaggerCoverageRestAssured());

        if (pathParams != null)
            for (Map.Entry<String, String> pathParam : pathParams.entrySet()) {
                requestSpecification.pathParam(pathParam.getKey(), pathParam.getValue());
            }
        if (headers != null)
            for (Map.Entry<String, Object> header : headers.entrySet()) {
                requestSpecification.header(header.getKey(), header.getValue());
            }
        if (queryParams != null)
            for (Map.Entry<String, Object> queryParam : queryParams.entrySet()) {
                requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
            }

        if (body != null) {
            requestSpecification.body(body);
        }

        if (testProp.consoleLog()) {
            requestSpecification.then()
                    .log()
                    .all();
        }
        Response resp = requestSpecification.get(testProp.BASE_URL() + endpoint);


        return resp;
    }


    public static Response putRequest(String endpoint, Map<String, Object> headers, Object body, Map<String, String> queryParams, Map<String, String> pathParams) {
        RequestSpecification requestSpecification = RestAssured.given().filter(new SwaggerCoverageRestAssured());

        if (headers != null)
            for (Map.Entry<String, Object> header : headers.entrySet()) {
                requestSpecification.header(header.getKey(), header.getValue());
            }
        if (queryParams != null)
            for (Map.Entry<String, String> queryParam : queryParams.entrySet()) {
                requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
            }

        if (pathParams != null)
            for (Map.Entry<String, String> pathParam : pathParams.entrySet()) {
                requestSpecification.pathParam(pathParam.getKey(), pathParam.getValue());
            }

        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);

        if (body != null) {
            requestSpecification.body(body);
        }

        if (testProp.consoleLog()) {
            requestSpecification.then()
                    .log()
                    .all();
        }

        Response resp = requestSpecification.put(testProp.BASE_URL() + endpoint);

        return resp;
    }

    public static Response deleteRequest(String endpoint, Map<String, Object> headers, Object body, Map<String, String> queryParams, Map<String, String> pathParams) {
        RequestSpecification requestSpecification = RestAssured.given().filter(new SwaggerCoverageRestAssured());

        if (headers != null)
            for (Map.Entry<String, Object> header : headers.entrySet()) {
                requestSpecification.header(header.getKey(), header.getValue());
            }
        if (queryParams != null)
            for (Map.Entry<String, String> queryParam : queryParams.entrySet()) {
                requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
            }

        if (pathParams != null)
            for (Map.Entry<String, String> pathParam : pathParams.entrySet()) {
                requestSpecification.pathParam(pathParam.getKey(), pathParam.getValue());
            }

        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);

        if (body != null) {
            requestSpecification.body(body);
        }

        if (testProp.consoleLog()) {
            requestSpecification.then()
                    .log()
                    .all();
        }

        Response resp = requestSpecification.delete(testProp.BASE_URL() + endpoint);

        return resp;
    }
}
