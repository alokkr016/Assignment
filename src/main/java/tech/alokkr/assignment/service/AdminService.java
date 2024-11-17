package tech.alokkr.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.alokkr.assignment.model.Assignment;
import tech.alokkr.assignment.repository.AssignmentRepository;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<Assignment> getAssignments() {
        return assignmentRepository.findAll();
    }

    public void acceptAssignment(String assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId).orElseThrow();
        assignment.setStatus("ACCEPTED");
        assignmentRepository.save(assignment);
    }

    public void rejectAssignment(String assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId).orElseThrow();
        assignment.setStatus("REJECTED");
        assignmentRepository.save(assignment);
    }
}
