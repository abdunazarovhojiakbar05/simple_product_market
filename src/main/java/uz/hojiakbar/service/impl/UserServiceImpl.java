package uz.hojiakbar.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.hojiakbar.repository.UserRepository;
import uz.hojiakbar.dto.request.UserRequestDto;
import uz.hojiakbar.dto.response.UserResponseDto;
import uz.hojiakbar.exception.ResourceNotFoundException;
import uz.hojiakbar.mapper.UserMapper;
import uz.hojiakbar.model.User;
import uz.hojiakbar.service.UserService;

import java.util.stream.Collectors;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto dto) {
        User user = UserMapper.toEntity(dto);

        User saved = userRepository.save(user);

        return UserMapper.toResponseDto(saved);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User topilmadi!"));
        return UserMapper.toResponseDto(user);
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto dto, Long id) {
         User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User topilmadi!"));

        user.setUsername(dto.getUsername());
        user.setFirstName(dto.getFirstName());
        user.setPassword(dto.getPassword());

        User saved = userRepository.save(user);
        return UserMapper.toResponseDto(saved);
    }


    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User topilmadi!"));
        userRepository.delete(user);
    }
}