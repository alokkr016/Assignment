package tech.alokkr.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.alokkr.assignment.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);
}
