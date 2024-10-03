package com.flyubro.aircraft_leasing_service.exception;

public class AircraftNotFoundException extends RuntimeException{

    public AircraftNotFoundException (){
        super("Aircraft not found");
    }
}
