package tech.alokkr.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.alokkr.assignment.model.Assignment;
import tech.alokkr.assignment.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/assignments")
    public List<Assignment> getAssignments() {
        return adminService.getAssignments();
    }

    @PostMapping("/assignments/{id}/accept")
    public void acceptAssignment(@PathVariable String id) {
        adminService.acceptAssignment(id);
    }

    @PostMapping("/assignments/{id}/reject")
    public void rejectAssignment(@PathVariable String id) {
        adminService.rejectAssignment(id);
    }
}
