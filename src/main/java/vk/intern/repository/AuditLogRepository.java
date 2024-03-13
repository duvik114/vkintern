package vk.intern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vk.intern.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}
