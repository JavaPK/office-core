package com.ttsw.officecore.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "Office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID officeId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Address_id", nullable = false)
    private UUID addressId;

    @Column(name = "Office_Details_Id", nullable = false)
    private UUID officeDetailsId;

    @Column(name = "User_Id", nullable = false)
    private UUID userId;
}
