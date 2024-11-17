package tech.alokkr.assignment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.alokkr.assignment.service.AdminService;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/assignments")
    public ResponseEntity<?> viewAssignments(@RequestParam String adminId) {
        return adminService.viewAssignments(adminId);
    }

    @PostMapping("/assignments/{id}")
    public ResponseEntity<?> updateAssignmentStatus(@PathVariable String id, @RequestParam String status) {
        return adminService.updateAssignmentStatus(id, status);
    }
}
