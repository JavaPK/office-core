package com.ttsw.officecore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID accountId;

    @Column(length = 85, nullable = false)
    private String email;

    @Column(length = 64, nullable = false)
    private String password;

    private UUID activateToken;

    @Column(nullable = false)
    private boolean isActive;

    private Date activateTokenValidationTime;
}
