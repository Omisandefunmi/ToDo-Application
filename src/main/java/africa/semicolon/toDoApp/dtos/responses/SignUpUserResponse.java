package africa.semicolon.toDoApp.dtos.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SignUpUserResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
}
