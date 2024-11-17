package tech.alokkr.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.alokkr.assignment.model.Assignment;
import tech.alokkr.assignment.model.User;
import tech.alokkr.assignment.repository.AssignmentRepository;
import tech.alokkr.assignment.service.JWTService;
import tech.alokkr.assignment.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AssignmentRepository assignmentRepository;

    // User Registration
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    // User Login
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // Passing username and password separately to the login method
        User authenticatedUser = userService.login(user.getUsername(), user.getPassword());
        if (authenticatedUser != null) {
            return jwtService.generateToken(authenticatedUser.getUsername(), authenticatedUser.getRole());
        }
        return "Invalid credentials";
    }

    // Upload Assignment with JWT token validation
    @PostMapping("/upload")
    public Assignment uploadAssignment(@RequestBody Assignment assignment, @RequestHeader("Authorization") String token) {
        // Extract username from token
        String username = jwtService.extractUsername(token.replace("Bearer ", ""));
        assignment.setUserId(username);
        return assignmentRepository.save(assignment);
    }

    // Fetch all users with ADMIN role
    @GetMapping("/admins")
    public List<User> getAllAdmins() {
        return userService.getAllAdmins();
    }

}
