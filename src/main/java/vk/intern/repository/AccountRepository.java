package vk.intern.repository;

import org.springframework.stereotype.Repository;
import vk.intern.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
