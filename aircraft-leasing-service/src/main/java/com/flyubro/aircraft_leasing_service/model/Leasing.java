package com.flyubro.aircraft_leasing_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "Leasing")
@Data
public class Leasing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_leasing")
    private long id;

    @OneToOne
    @JoinColumn(name = "aircraft_registration",nullable = false)
    private Aircraft aircraft;

    @OneToOne
    @JoinColumn(name = "license_number",nullable = false)
    private Pilot pilot;

    @Column (name = "lease_price")
    private Double leasePrice;

    @Column (name = "lease_h")
    private Integer leaseHours;

}
