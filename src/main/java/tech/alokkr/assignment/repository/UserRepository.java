package tech.alokkr.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.alokkr.assignment.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
