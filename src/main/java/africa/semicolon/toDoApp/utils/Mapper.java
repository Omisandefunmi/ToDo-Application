package africa.semicolon.toDoApp.utils;

import africa.semicolon.toDoApp.data.models.User;
import africa.semicolon.toDoApp.dtos.requests.SignUpUserRequest;
import africa.semicolon.toDoApp.dtos.responses.SignUpUserResponse;
import africa.semicolon.toDoApp.dtos.responses.UpdateDetailsResponse;

public class Mapper {
    public static void map(SignUpUserRequest request, User user) {
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setPassword(request.getPassword());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
    }

    public static void map(User savedUser, SignUpUserResponse response) {
        savedUser.setEmail(response.getEmail());
        savedUser.setFirstName(response.getFirstName());
        savedUser.setLastName(response.getLastName());
        savedUser.setUsername(response.getUsername());
    }

    public static void map(User user, UpdateDetailsResponse responseBody) {
        responseBody.setEmail(user.getEmail());
        responseBody.setFirstName(user.getFirstName());
        responseBody.setLastName(user.getLastName());
        responseBody.setUsername(user.getUsername());
    }
}
