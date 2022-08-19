package africa.semicolon.toDoApp.dtos.responses;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateDetailsResponse {
    private String email;
    private String firstName;
    private String lastName;
    private String username;
}
