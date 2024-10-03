package com.flyubro.aircraft_leasing_service.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "aircraft")
@Data
public class Aircraft {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "aircraft_id")
    private Long aircraftId;
    @Column (name = "aircraft_registration")
    private String aircraftReg;
    @Column (name = "autonomy")
    private Long autonomy;
    @Column (name = "price_h")
    private Long priceHouer;
}
