package tech.alokkr.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.alokkr.assignment.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
