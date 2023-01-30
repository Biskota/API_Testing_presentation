package properties;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:testing.properties")
public interface TestInitValues extends Config {

    @Key("BASE_URL")
    String BASE_URL();

    @Key("id")
    int id();

    @Key("username")
    String username();

    @Key("firstName")
    String firstName();

    @Key("lastName")
    String lastName();

    @Key("email")
    String email();

    @Key("password")
    String password();

    @Key("phone")
    String phone();

    @Key("userStatus")
    int userStatus();

    @Key("consoleLog")
    Boolean consoleLog();
}
