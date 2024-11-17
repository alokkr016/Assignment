package tech.alokkr.assignment.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "assignments")
@Data
public class Assignment {
    @Id
    private String id;
    private String userId;
    private String task;
    private String admin;
    private LocalDateTime timestamp;
    private String status; // "PENDING", "ACCEPTED", "REJECTED"

    // Getters and setters...
}
