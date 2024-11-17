package tech.alokkr.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import tech.alokkr.assignment.model.Role;
import tech.alokkr.assignment.model.User;
import tech.alokkr.assignment.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email is already in use.");
        }
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt())); // Encrypt the password
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));
        if (BCrypt.checkpw(password, user.getPassword())) {
            return user;
        } else {
            throw new IllegalArgumentException("Invalid credentials");
        }
    }


    public List<User> getAllAdmins() {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole() == Role.ROLE_ADMIN)
                .collect(Collectors.toList());
    }
}
