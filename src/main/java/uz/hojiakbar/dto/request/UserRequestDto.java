package uz.hojiakbar.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.hojiakbar.enums.UserRole;


@Getter
@Setter
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {

    @NotBlank(message = "username will not empty")
    String username;

    @NotBlank(message = "ism bosh bolishi mukin emas")
    String firstName;

    @NotBlank(message = "parol bosh bolishi mumkin emas")
    @Size(min = 4, message = "parol juda qisqa")
    String password;

    UserRole role;

    double balance;
}
