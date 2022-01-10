package kg.itschool.security.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.itschool.security.model.entity.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    Long id;
    String firstName;
    String lastName;
    String email;
    String username;
    Role role;

    @JsonIgnore
    String password;
}