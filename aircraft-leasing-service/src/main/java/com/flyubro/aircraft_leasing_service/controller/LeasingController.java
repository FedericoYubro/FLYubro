package com.flyubro.aircraft_leasing_service.controller;

import com.flyubro.aircraft_leasing_service.client.CoreClient;
import com.flyubro.aircraft_leasing_service.model.Aircraft;
import com.flyubro.aircraft_leasing_service.model.Leasing;
import com.flyubro.aircraft_leasing_service.model.Pilot;
import com.flyubro.aircraft_leasing_service.service.AircraftService;
import com.flyubro.aircraft_leasing_service.service.LeasingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leasing")
public class LeasingController {

    @Autowired
    CoreClient coreClient;
    @Autowired
    LeasingService leasingService;
    @Autowired
    AircraftService aircraftService;

    @GetMapping("/list")
    public ResponseEntity<List<Leasing>> recoverAllLeasing (){
        List <Leasing> leasingList = this.leasingService.getAllLeasing();

        if (leasingList.isEmpty())
        {
            return new ResponseEntity<>(leasingList, HttpStatus.NO_CONTENT);//204 no es error
        } else {
            return new ResponseEntity<>(leasingList,HttpStatus.OK);
        }
    }

    @PostMapping("/contract")
    public ResponseEntity <Leasing> contractLeasing(@RequestParam String aircraftReg,
                                                    @RequestParam Integer licenseNumber,
                                                    @RequestParam Integer leaseHours) {

        Aircraft aircraft = aircraftService.searchAircraft(aircraftReg);
        Pilot pilot = coreClient.searchPilotByLicense(licenseNumber).getBody();

        Leasing leasing = leasingService.contractLeasing(aircraft, pilot, leaseHours);
        return new ResponseEntity<>(leasing,HttpStatus.CREATED);
    }
}
