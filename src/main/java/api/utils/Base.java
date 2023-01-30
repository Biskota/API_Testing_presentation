package api.utils;

import api.objects.User;
import org.aeonbits.owner.ConfigFactory;
import properties.TestInitValues;

public class Base {

    public static final TestInitValues testProp = ConfigFactory.create(TestInitValues.class);

    public static final User user = new User(testProp.id(), testProp.username(), testProp.firstName(), testProp.lastName(), testProp.email(), testProp.password(), testProp.phone(), testProp.userStatus());
}
