package com.flyubro.core_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pilot")
@Data
public class Pilot {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "record_id")
    private Long recordId;
    @Column (name = "full_name")
    private String fullName;
    @Column (name = "license_number")
    private long licenseNumber;
    @Column (name = "hours_flight")
    private float hours;
    @Column (name = "license_type")
    private LicenseType licence;

    private enum LicenseType
    {
        PPA,PCA,INST,TLA;
    }

}
