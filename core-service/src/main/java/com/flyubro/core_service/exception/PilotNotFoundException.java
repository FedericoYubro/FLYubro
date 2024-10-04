package com.flyubro.core_service.exception;

public class PilotNotFoundException extends RuntimeException{
    public PilotNotFoundException(){
        super("Pilot not found");
    }

}
