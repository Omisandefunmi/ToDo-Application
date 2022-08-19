package africa.semicolon.toDoApp.dtos.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
}

