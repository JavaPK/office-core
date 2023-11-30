package com.ttsw.officecore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Account")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID accountId;

    @Column(name = "Email", length = 85, nullable = false)
    String email;

    @Column(name = "Password", length = 64, nullable = false)
    String password;

    @Column(name = "Active_Token")
    UUID activeToken;

    @Column(name = "Active", nullable = false)
    boolean isActive;

    @Column(name = "Timestamp_Validation_Time")
    Date timestampTokenValidationTime;
}
