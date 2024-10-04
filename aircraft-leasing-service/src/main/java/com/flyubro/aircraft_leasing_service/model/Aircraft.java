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
    @Column (name = "aircraft_model")
    private String aircraftModel;
    @Column (name = "horse_power")
    private Long hp;
    @Column (name = "autonomy")
    private double autonomy;
    @Column (name = "seat")
    private Long seat;
    @Column (name = "price_h")
    private Long priceHouer;
}
