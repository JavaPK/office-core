package com.ttsw.officecore.repository;

import com.ttsw.officecore.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    Optional<Account> findByEmail();

    //Account createAccount();

    Account findByActivationToken();
}