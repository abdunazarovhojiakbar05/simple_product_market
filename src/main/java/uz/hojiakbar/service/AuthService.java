package uz.hojiakbar.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.hojiakbar.model.User;
import uz.hojiakbar.repository.UserRepository;
import uz.hojiakbar.utils.JwtUtil;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public Map<String, String> login(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        String token = jwtUtil.generateToken(username);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return response;
    }

    public Map<String, String> register(String username, String password, String firstName) {

        if(username.isEmpty() || password.isEmpty() || firstName.isEmpty())
            return null;


        if(userRepository.findByUsername(username).isPresent())
            return null;

        String encodedPassword = passwordEncoder.encode(password);

        userRepository.save(new User(username,  firstName , encodedPassword));

        return login(username, password);
    }
}