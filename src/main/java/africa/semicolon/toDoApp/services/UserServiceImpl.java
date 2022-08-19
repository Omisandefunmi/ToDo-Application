package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.data.models.User;
import africa.semicolon.toDoApp.data.repositories.UserRepository;
import africa.semicolon.toDoApp.dtos.requests.SignUpUserRequest;
import africa.semicolon.toDoApp.dtos.responses.SignUpUserResponse;
import africa.semicolon.toDoApp.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public SignUpUserResponse signUpUser(SignUpUserRequest request) {
        User user = new User();
        Mapper.map(request, user);
        userRepository.save(user);
        SignUpUserResponse response = new SignUpUserResponse();
        response.setMessage("success");
        return response;
    }
    @Override
    public int count() {
        return (int) userRepository.count();
    }
}
