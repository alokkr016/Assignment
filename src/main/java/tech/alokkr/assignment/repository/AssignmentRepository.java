package tech.alokkr.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.alokkr.assignment.model.Assignment;

import java.util.List;

public interface AssignmentRepository extends MongoRepository<Assignment, String> {
    List<Assignment> findByAdmin(String admin);
}
