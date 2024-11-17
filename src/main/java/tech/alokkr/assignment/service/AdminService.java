package tech.alokkr.assignment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.alokkr.assignment.model.Assignment;
import tech.alokkr.assignment.repository.AssignmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AssignmentRepository assignmentRepository;

    public ResponseEntity<?> viewAssignments(String adminId) {
        List<Assignment> assignments = assignmentRepository.findByAdminId(adminId);
        return ResponseEntity.ok(assignments);
    }

    public ResponseEntity<?> updateAssignmentStatus(String id, String status) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if (assignment != null) {
            assignment.setStatus(status);
            assignmentRepository.save(assignment);
            return ResponseEntity.ok("Assignment status updated successfully");
        }
        return ResponseEntity.status(404).body("Assignment not found");
    }
}
