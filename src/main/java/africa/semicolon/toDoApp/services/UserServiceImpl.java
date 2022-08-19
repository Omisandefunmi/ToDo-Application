package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.data.models.User;
import africa.semicolon.toDoApp.data.repositories.UserRepository;
import africa.semicolon.toDoApp.dtos.requests.LogInUserRequest;
import africa.semicolon.toDoApp.dtos.requests.SignUpUserRequest;
import africa.semicolon.toDoApp.dtos.requests.UpdateDetailsRequest;
import africa.semicolon.toDoApp.dtos.responses.LogInUserResponse;
import africa.semicolon.toDoApp.dtos.responses.SignUpUserResponse;
import africa.semicolon.toDoApp.dtos.responses.UpdateDetailsResponse;
import africa.semicolon.toDoApp.exceptions.InvalidDetailsException;
import africa.semicolon.toDoApp.exceptions.UserExistsException;
import africa.semicolon.toDoApp.exceptions.UserNotFoundException;
import africa.semicolon.toDoApp.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public SignUpUserResponse signUpUser(SignUpUserRequest request) {
        userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UserExistsException(request.getEmail()+" is already registered"));
        User user = new User();
        Mapper.map(request, user);
        User savedUser = userRepository.save(user);
        SignUpUserResponse response = new SignUpUserResponse();
        Mapper.map(savedUser, response);
        return response;
    }
    @Override
    public int count() {
        return (int) userRepository.count();
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public LogInUserResponse LogInUser(LogInUserRequest logInRequest) {
        User user = validateUser(logInRequest.getEmail());
        LogInUserResponse response = new LogInUserResponse();
        if(!user.getPassword().equals(logInRequest.getPassword())){
            throw new InvalidDetailsException("Invalid details");
        }
        response.setMessage("Welcome "+user.getUsername().toUpperCase());
        return response;
    }

    @Override
    public UpdateDetailsResponse updateDetails(UpdateDetailsRequest request) {
       User user = validateUser(request.getEmail());
       if (!user.getPassword().equals(request.getPassword())){
           throw new InvalidDetailsException("Invalid details");
       }
       boolean isUpdated = false;
       if (!(request.getPassword() == null || request.getPassword().equals(" "))){
           user.setPassword(request.getPassword());
           isUpdated = true;
       }
       if(!(request.getUsername() == null || request.getUsername().equals(" "))){
           user.setUsername(request.getUsername());
           isUpdated = true;
       }
       if (!(request.getFirstName() == null || request.getFirstName().equals(" "))){
           user.setFirstName(request.getFirstName());
           isUpdated = true;
       }
       if (!(request.getLastName() == null || request.getLastName().equals(" "))){
           user.setLastName(request.getLastName());
           isUpdated = true;
       }
       if(isUpdated){
           User updatedUser = userRepository.save(user);
           return UpdateDetailsResponse.builder()
                   .email(updatedUser.getEmail())
                   .firstName(updatedUser.getFirstName())
                   .lastName(updatedUser.getLastName())
                   .username(updatedUser.getUsername())
                   .build();
       }
        UpdateDetailsResponse responseBody = new UpdateDetailsResponse();
        Mapper.map(user, responseBody);
        return responseBody;
    }

    private User validateUser(String email){
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()){
            throw new UserNotFoundException("This email is not registered");
        }
        return user.get();
    }


}