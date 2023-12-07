package com.ttsw.officecore.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Builder
@Table(name = "ACCOUNT")
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCOUNT_ID")
    private UUID accountId;

    @Column(name = "EMAIL", length = 85, nullable = false)
    private String email;

    @Column(name = "PASSWORD", length = 64, nullable = false)
    private String password;

    @Column(name = "ACTIVE_TOKEN")
    private UUID activationToken;

    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean isActive;

    @Column(name = "ACTIVATE_TOKEN_VALIDATION_TIME")
    private Date timestampTokenValidationTime;
}
