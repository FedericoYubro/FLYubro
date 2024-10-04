package com.flyubro.aircraft_leasing_service.service;

import com.flyubro.aircraft_leasing_service.exception.AircraftNotFoundException;
import com.flyubro.aircraft_leasing_service.model.Aircraft;
import com.flyubro.aircraft_leasing_service.model.Leasing;
import com.flyubro.aircraft_leasing_service.model.Pilot;
import com.flyubro.aircraft_leasing_service.repository.AircraftRepository;
import com.flyubro.aircraft_leasing_service.repository.LeasingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeasingService {

    private LeasingRepository leasingRepository;
    private AircraftRepository aircraftRepository;

    @Autowired
    public LeasingService (LeasingRepository leasingRepository, AircraftRepository aircraftRepository/*,PilotRepository pilotRepository*/){
        this.leasingRepository = leasingRepository;
        this.aircraftRepository = aircraftRepository;
    }

    public List<Leasing> getAllLeasing (){
        return this.leasingRepository.findAll();
    }

    public Leasing contractLeasing(Aircraft aircraft, Pilot pilot, Integer leaseHours ){

        Aircraft reqAircraft = aircraftRepository.findAircraftByRegistration(aircraft.getAircraftReg())
                .orElseThrow(AircraftNotFoundException::new);

        double finalPrice = aircraft.getPriceHouer() * leaseHours;

        Leasing leasing = new Leasing();
        leasing.setAircraft(reqAircraft);
        leasing.setPilot(pilot);
        leasing.setLeaseHours(leaseHours);
        leasing.setLeasePrice(finalPrice);
        return leasingRepository.save(leasing);
    }




}
