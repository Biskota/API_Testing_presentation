package api;

import api.steps.UserSteps;
import api.utils.BaseTest;
import org.testng.annotations.Test;

import static api.utils.AssertsUtil.*;
import static properties.TestData.*;

public class UserTests extends BaseTest {

    private final UserSteps userSteps = new UserSteps();

    @Test
    public void createUser() {
        assertStatusCode(userSteps.userCreate(user), 200);
    }
}
