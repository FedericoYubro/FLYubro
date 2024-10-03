package com.flyubro.core_service.model;

import lombok.Data;
import lombok.Getter;

@Getter
public class Coordinate {
    private double latitude;
    private double longitude;

    public Coordinate(double latitud, double longitud) {
        this.latitude = latitud;
        this.longitude = longitud;
    }

    // Form Haversine
    public double Distance(Coordinate otherCoordinate) {
        final int RADIO_EARTH_KM = 6371; // Radio
        double deltaLat = Math.toRadians(otherCoordinate.getLatitude() - this.latitude);
        double deltaLong = Math.toRadians(otherCoordinate.getLongitude() - this.longitude);
        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(otherCoordinate.getLatitude())) *
                        Math.sin(deltaLong / 2) * Math.sin(deltaLong / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return RADIO_EARTH_KM * c;
    }
}
