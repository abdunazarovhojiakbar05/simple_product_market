package uz.hojiakbar.service;

  import uz.hojiakbar.dto.request.UserRequestDto;
import uz.hojiakbar.dto.response.UserResponseDto;


import java.util.List;

    public interface UserService {
        UserResponseDto createUser(UserRequestDto dto);
        List<UserResponseDto> getAllUsers();
        UserResponseDto getUserById(Long id);
        UserResponseDto updateUser(UserRequestDto dto, Long id);
        void deleteUser(Long id);
    }













