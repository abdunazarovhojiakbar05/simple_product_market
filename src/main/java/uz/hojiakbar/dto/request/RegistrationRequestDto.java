package uz.hojiakbar.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.hojiakbar.enums.UserRole;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistrationRequestDto {

    String username;
    String password;
    String firstName;
    UserRole role = UserRole.USER;
    double balance = 0.0;


}
