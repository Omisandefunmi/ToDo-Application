package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.dtos.requests.LogInUserRequest;
import africa.semicolon.toDoApp.dtos.requests.SignUpUserRequest;
import africa.semicolon.toDoApp.dtos.responses.LogInUserResponse;
import africa.semicolon.toDoApp.dtos.responses.SignUpUserResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService.deleteAll();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testThatUserServiceRegister() {
        SignUpUserRequest request = new SignUpUserRequest();
        request.setEmail("de@mail.com");
        request.setFirstName("john");
        request.setLastName("ade");
        request.setPassword("adele");

        SignUpUserResponse response = userService.signUpUser(request);
        assertEquals(1, userService.count());
    }
    @Test
    void testThatUserCanLogIn(){
        SignUpUserRequest request = new SignUpUserRequest();
        request.setEmail("de@mail.com");
        request.setFirstName("john");
        request.setLastName("ade");
        request.setPassword("adele");

        userService.signUpUser(request);


        LogInUserRequest logInRequest = new LogInUserRequest();
        logInRequest.setEmail("de@mail.com");
        logInRequest.setPassword("adele");

        LogInUserResponse response = userService.LogInUser(logInRequest);
        assertEquals("Log in success", response.getMessage());
    }

    @Test
    void testThatUserCanCreateTask(){
      CreateTaskRequest request = new CreateTaskRequest();
    }
}
