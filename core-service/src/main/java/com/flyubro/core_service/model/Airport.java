package com.flyubro.core_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "airport")
@Data
public class Airport {
    @Id
    @GeneratedValue
    @Column (name = "aip_id")
    private long airportId;
    @Column (name = "aip_name")
    private String airportName;
    @Column (name = "aip_icao")
    private String icao;
    @Column (name = "aip_country")
    private String  country;

    /*
    @Column (name = "latitude")
    private Coordinate lat;//+-HH.MMMM
    @Column (name = "longitude")
    private Coordinate lon;//+-HHH.MMMM
    */
}
