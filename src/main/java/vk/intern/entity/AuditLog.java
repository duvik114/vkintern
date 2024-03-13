package vk.intern.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String operation;
    private LocalDateTime timestamp;
    private String details;

    public AuditLog() {
    }

    public AuditLog(String username, String operation, LocalDateTime timestamp, String details) {
        this.username = username;
        this.operation = operation;
        this.timestamp = timestamp;
        this.details = details;
    }
}
