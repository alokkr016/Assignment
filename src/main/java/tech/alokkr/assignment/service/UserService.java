package tech.alokkr.assignment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.alokkr.assignment.model.Assignment;
import tech.alokkr.assignment.model.User;
import tech.alokkr.assignment.repository.AssignmentRepository;
import tech.alokkr.assignment.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AssignmentRepository assignmentRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity<?> registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    public ResponseEntity<?> loginUser(User user) {
        User foundUser = userRepository.findByEmail(user.getEmail()).orElse(null);
        if (foundUser != null && passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    public ResponseEntity<?> uploadAssignment(Assignment assignment) {
        assignmentRepository.save(assignment);
        return ResponseEntity.ok("Assignment uploaded successfully");
    }

    public ResponseEntity<?> getAllAdmins() {
        List<User> admins = userRepository.findAll().stream()
                .filter(user -> "ADMIN".equalsIgnoreCase(user.getRole()))
                .toList();
        return ResponseEntity.ok(admins);
    }
}
