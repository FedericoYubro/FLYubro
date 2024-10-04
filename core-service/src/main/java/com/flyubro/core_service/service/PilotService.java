package com.flyubro.core_service.service;

import com.flyubro.core_service.model.Pilot;
import com.flyubro.core_service.repository.PilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotService {
    @Autowired
    PilotRepository pilotRepository;

    public List<Pilot> getAllPilots (){
        return this.pilotRepository.findAll();
    }
    public Pilot getPilotByLicense (long licenseNumber){
        return this.pilotRepository.findByLicenseNumber(licenseNumber).orElseThrow(() -> new RuntimeException("Pilot not found"));
    }

    public void registPilot (Pilot pilot){
        this.pilotRepository.saveAndFlush(pilot);
    }

}
