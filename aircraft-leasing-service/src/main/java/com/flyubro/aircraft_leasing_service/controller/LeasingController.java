package com.flyubro.aircraft_leasing_service.controller;

import com.flyubro.aircraft_leasing_service.model.Aircraft;
import com.flyubro.aircraft_leasing_service.model.Leasing;
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
    LeasingService leasingService;

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
    public ResponseEntity <Leasing> contractLeasing(@RequestBody Aircraft aircraft,
                                                    @RequestParam Integer licenseNumber,
                                                    @RequestParam Integer leaseHours) {
        Leasing leasing = leasingService.contractLeasing(aircraft, licenseNumber, leaseHours);
        return new ResponseEntity<>(leasing,HttpStatus.CREATED);
    }
}
