package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.dtos.requests.LogInUserRequest;
import africa.semicolon.toDoApp.dtos.requests.SignUpUserRequest;
import africa.semicolon.toDoApp.dtos.requests.UpdateDetailsRequest;
import africa.semicolon.toDoApp.dtos.responses.LogInUserResponse;
import africa.semicolon.toDoApp.dtos.responses.SignUpUserResponse;
import africa.semicolon.toDoApp.dtos.responses.UpdateDetailsResponse;

public interface UserService {
    SignUpUserResponse signUpUser(SignUpUserRequest request);

    int count();

    void deleteAll();

    LogInUserResponse LogInUser(LogInUserRequest logInRequest);
    UpdateDetailsResponse updateDetails(UpdateDetailsRequest request);
}
