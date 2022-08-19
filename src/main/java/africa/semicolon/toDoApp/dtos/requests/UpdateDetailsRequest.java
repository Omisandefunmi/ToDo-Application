package africa.semicolon.toDoApp.dtos.requests;

import lombok.Getter;
@Getter
public class UpdateDetailsRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String username;
}
