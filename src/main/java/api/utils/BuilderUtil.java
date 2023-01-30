package api.utils;

import api.builders.CreateUser;

public class BuilderUtil {

    public CreateUser buildCreateUser(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus) {
        return CreateUser.builder()
                .id(id)
                .username(username)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .phone(phone)
                .userStatus(userStatus)
                .build();
    }
}
