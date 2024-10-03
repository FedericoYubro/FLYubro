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
import java.util.concurrent.atomic.AtomicReference;

@Service
public class LeasingService {

    private LeasingRepository leasingRepository;
    private AircraftRepository aircraftRepository;
    //private PilotRepository pilotRepository;

    @Autowired
    public LeasingService (LeasingRepository leasingRepository, AircraftRepository aircraftRepository/*,PilotRepository pilotRepository*/){
        this.leasingRepository = leasingRepository;
        this.aircraftRepository = aircraftRepository;
        //this.pilotRepository = pilotRepository;
    }

    public List<Leasing> getAllLeasing (){
        return this.leasingRepository.findAll();
    }

    public Leasing contractLeasing(Aircraft aircraft, long licenseNumber, Integer leaseHours ){//

        Aircraft reqAircraft = aircraftRepository.findAircraftByRegistration(aircraft.getAircraftReg())
                .orElseThrow(AircraftNotFoundException::new);

        //Pilot pilot = pilotRepository.findByLicenseNumber(licenseNumber)
        //        .orElseThrow(() -> new IllegalArgumentException("Pilot not found"));

        double finalPrice = aircraft.getPriceHouer() * leaseHours;

        // Crea un nuevo contrato de leasing
        Leasing leasing = new Leasing();
        leasing.setAircraft(reqAircraft);
        //leasing.setPilot(pilot);
        leasing.setLeaseHours(leaseHours);
        leasing.setLeasePrice(finalPrice);
        return leasingRepository.save(leasing);
    }




}
