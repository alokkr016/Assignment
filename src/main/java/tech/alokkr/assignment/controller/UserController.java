package tech.alokkr.assignment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.alokkr.assignment.model.Assignment;
import tech.alokkr.assignment.model.User;
import tech.alokkr.assignment.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadAssignment(@RequestBody Assignment assignment) {
        return userService.uploadAssignment(assignment);
    }

    @GetMapping("/admins")
    public ResponseEntity<?> getAllAdmins() {
        return userService.getAllAdmins();
    }
}
