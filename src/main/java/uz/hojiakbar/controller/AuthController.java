package uz.hojiakbar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.hojiakbar.dto.request.LoginRequest;
import uz.hojiakbar.dto.request.RegistrationRequestDto;
import uz.hojiakbar.service.AuthService;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {
        return authService.login(request.getUsername(), request.getPassword());
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody RegistrationRequestDto request) {
        return authService.register(request.getUsername(), request.getPassword(), request.getFirstName());
    }


}