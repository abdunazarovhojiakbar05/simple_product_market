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
public class UserResponseDto {

   Long id;
   String token;
   String username;
   String firstName;
   UserRole role;
   double balance;

   public UserResponseDto(Long id, String username, String firstName, UserRole role, double balance) {
      this.id = id;
      this.username = username;
      this.firstName = firstName;
      this.role = role;
      this.balance = balance;
   }
}