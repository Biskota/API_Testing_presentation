package api.steps;

import api.builders.CreateUser;
import api.objects.User;
import api.utils.BuilderUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.util.HashMap;

import static api.endpoints.Endpoints.CREATE_USER;
import static api.endpoints.Endpoints.GET_USER;
import static api.utils.ApiServices.*;

public class UserSteps {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private final BuilderUtil builderUtil = new BuilderUtil();

    @SneakyThrows
    @Step("Create user")
    public Response userCreate(User user) {
        CreateUser createUser = builderUtil.buildCreateUser(user.getId(), user.getUsername(), user.getFirstName(),
                user.getLastName(), user.getEmail(), user.getPassword(), user.getPhone(), user.getUserStatus());
        return postRequest(CREATE_USER, null, objectMapper.writeValueAsString(createUser), null, null);
    }

    @SneakyThrows
    @Step("Get user")
    public Response getUser(String username) {
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("username", username);

        return getRequest(GET_USER, null, null, null, pathParams);
    }

}
