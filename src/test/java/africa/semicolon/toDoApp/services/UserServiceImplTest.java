package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.dtos.requests.SignUpUserRequest;
import africa.semicolon.toDoApp.dtos.responses.SignUpUserResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {

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
}
