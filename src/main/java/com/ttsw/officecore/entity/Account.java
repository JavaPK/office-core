package com.ttsw.officecore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID accountId;

    @Column(name = "Email", length = 85, nullable = false)
    private String email;

    @Column(name = "Password", length = 64, nullable = false)
    private String password;

    @Column(name = "ActivationToken")
    private UUID activationToken;

    @Column(name = "Active", nullable = false)
    private boolean isActive;

    @Column(name = "Timestamp_Validation_Time")
    private Date timestampTokenValidationTime;
}
