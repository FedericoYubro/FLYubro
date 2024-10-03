package com.flyubro.aircraft_leasing_service.service;

import com.flyubro.aircraft_leasing_service.exception.AircraftNotFoundException;
import com.flyubro.aircraft_leasing_service.model.Aircraft;
import com.flyubro.aircraft_leasing_service.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService {

    @Autowired
    AircraftRepository aircraftRepository;

    public List<Aircraft> getAllAircraft (){
        return this.aircraftRepository.findAll();
    }

    public Aircraft searchAircraft(String aircraftReg){
        return this.aircraftRepository.findAircraftByRegistration(aircraftReg)
                .orElseThrow(AircraftNotFoundException::new);
    }

    public void registAircraft (Aircraft aircraft){
        this.aircraftRepository.saveAndFlush(aircraft);
    }
}
