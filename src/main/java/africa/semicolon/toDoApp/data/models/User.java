package africa.semicolon.toDoApp.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

}
