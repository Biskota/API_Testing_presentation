package api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.viclovsky.swagger.coverage.SwaggerCoverageRestAssured;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;

import java.util.Map;

import static api.utils.Base.testProp;
import static org.apache.http.HttpHeaders.DATE;

public class ApiServices {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Response postRequest(String endpoint, Map<String, Object> headers, Object body, Map<String, String> queryParams, Map<String, String> pathParams) {
        RequestSpecification requestSpecification = RestAssured.given();

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

        Allure.addAttachment("Response", getAllureResponse(testProp.BASE_URL() + endpoint, resp, body));


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

        Allure.addAttachment("Response", getAllureResponse(testProp.BASE_URL() + endpoint, resp, body));


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

        Allure.addAttachment("Response", getAllureResponse(testProp.BASE_URL() + endpoint, resp, body));

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

        Allure.addAttachment("Response", getAllureResponse(testProp.BASE_URL() + endpoint, resp, body));

        return resp;
    }

    @SneakyThrows
    public static String getAllureResponse(String endpoint, Response resp, Object body) {

        String request_date = resp.getHeader(DATE);
        String responseStatus = String.valueOf(resp.getStatusCode());
        String requestBody = body != null ? objectMapper.writeValueAsString(body) : "";


        return "\n\nRequest date: " + request_date +
                "\n\nEndpoint: " + endpoint +
                "\n\nRequest body: " + requestBody +
                "\n\nResponse status code: " + responseStatus +
                "\n\nResponse: " + resp.getBody().asString();
    }
}
