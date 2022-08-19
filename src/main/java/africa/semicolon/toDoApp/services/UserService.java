package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.dtos.requests.SignUpUserRequest;
import africa.semicolon.toDoApp.dtos.responses.SignUpUserResponse;

public interface UserService {
    SignUpUserResponse signUpUser(SignUpUserRequest request);

    int count();

}
