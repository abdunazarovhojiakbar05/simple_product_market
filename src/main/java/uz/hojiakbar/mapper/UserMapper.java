package uz.hojiakbar.mapper;

import uz.hojiakbar.dto.request.UserRequestDto;
import uz.hojiakbar.dto.response.UserResponseDto;
import uz.hojiakbar.enums.UserRole;
import uz.hojiakbar.model.User;

public class UserMapper {


    public  static UserResponseDto toResponseDto(User user) {
        if (user == null) return null;

        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getRole(),
                user.getBalance()
        );
    }


    public static User toEntity(UserRequestDto dto) {
        if (dto == null) return null;

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setFirstName(dto.getFirstName());
        user.setPassword(dto.getPassword());
        user.setRole(UserRole.USER);
        user.setBalance(0.0);
        return user;
    }


    public static void updateEntityFromDto(UserRequestDto dto, User user) {
        if (dto == null || user == null) return;
        user.setUsername(dto.getUsername());
        user.setFirstName(dto.getFirstName());
        user.setPassword(dto.getPassword());
    }
}
