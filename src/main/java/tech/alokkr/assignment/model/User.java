package tech.alokkr.assignment.model;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")
@Data
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    @Email
    private String email;
    private Role role;

    // Getters and setters...
}
