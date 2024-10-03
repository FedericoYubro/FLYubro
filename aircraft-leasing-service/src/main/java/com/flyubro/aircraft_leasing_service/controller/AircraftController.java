package com.flyubro.aircraft_leasing_service.controller;


import com.flyubro.aircraft_leasing_service.model.Aircraft;
import com.flyubro.aircraft_leasing_service.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircraft")

public class AircraftController {
    @Autowired
    AircraftService aircraftService;

    @GetMapping("/list")
    public ResponseEntity <List<Aircraft>> recoverAllAircraft (){
        List <Aircraft> AircraftList = this.aircraftService.getAllAircraft();

        if (AircraftList.isEmpty())
        {
            return new ResponseEntity<>(AircraftList, HttpStatus.NO_CONTENT);//204 no es error
        } else {
            return new ResponseEntity<>(AircraftList,HttpStatus.OK);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<Aircraft> searchAircraft(@RequestParam String aircraftReg) {
        Aircraft aircraft = this.aircraftService.searchAircraft(aircraftReg);

        if (aircraft != null) {
            return new ResponseEntity<>(aircraft, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/regist")
    public ResponseEntity <String> registAircraft(@RequestBody Aircraft newAircraft){
        this.aircraftService.registAircraft(newAircraft);
        return new ResponseEntity<>("Aircraft Registred Succesfull",HttpStatus.CREATED);
    }


}
