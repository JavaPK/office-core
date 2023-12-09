package com.ttsw.officecore.repository;

import com.ttsw.officecore.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query("SELECT a FROM Account a WHERE a.isActive=true")
    Optional<Account> findByEmail(String email);

    Account findByActivateToken(UUID activationToken);
}
