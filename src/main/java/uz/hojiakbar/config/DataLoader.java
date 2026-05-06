package uz.hojiakbar.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.hojiakbar.enums.UserRole;
import uz.hojiakbar.model.User;
import uz.hojiakbar.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setFirstName("Admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(UserRole.ADMIN);
            admin.setBalance(0.0);
            userRepository.save(admin);
            System.out.println("Dastlabki admin yaratildi: admin / admin123");
        }
    }
}