package tech.alokkr.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.alokkr.assignment.model.Assignment;
import tech.alokkr.assignment.model.User;
import tech.alokkr.assignment.repository.AssignmentRepository;
import tech.alokkr.assignment.service.JWTService;
import tech.alokkr.assignment.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private AssignmentRepository assignmentRepository;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User authenticatedUser = userService.login(user.getUsername(), user.getPassword());
        if (authenticatedUser != null) {
            return jwtService.generateToken(authenticatedUser.getUsername());
        }
        return "Invalid credentials";
    }

    @PostMapping("/upload")
    public Assignment uploadAssignment(@RequestBody Assignment assignment, @RequestHeader("Authorization") String token) {
        // Extract username from the token
        String userId = token;
        assignment.setUserId(userId);
        return assignmentRepository.save(assignment);
    }
}
