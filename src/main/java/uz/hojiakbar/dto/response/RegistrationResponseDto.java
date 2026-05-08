package uz.hojiakbar.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.hojiakbar.enums.UserRole;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class RegistrationResponseDto {

    String username;
    String password;
    String firstName;
    UserRole role = UserRole.USER;
    double balance = 0.0;



}
