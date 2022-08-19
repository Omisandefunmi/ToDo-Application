package africa.semicolon.toDoApp.dtos.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LogInUserRequest {
    private String email;
    private String password;
}
