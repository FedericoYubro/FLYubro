package com.flyubro.core_service.controller;

import com.flyubro.core_service.model.Pilot;
import com.flyubro.core_service.service.PilotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilot")//si se marca la clase, todos los endpoint tiene esta base de web
@Tag(name = "Product API", description = "API to manage Products")
public class PilotController {

    @Autowired
    PilotService pilotService;

    @GetMapping("/list")//Metodo endpoint metodo ejecutado por postman
    public ResponseEntity <List<Pilot>> recoverAllPilot (){
        List <Pilot> pilotList = this.pilotService.getAllPilots();

        if (pilotList.isEmpty())
        {
            return new ResponseEntity<>(pilotList,HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(pilotList,HttpStatus.OK);
        }
    }

    @GetMapping("/search/{licenseNumber}")
    public ResponseEntity <Pilot> searchPilotByLicense(@PathVariable long licenseNumber){
        Pilot pilot = this.pilotService.getPilotByLicense(licenseNumber);
        return new ResponseEntity<Pilot>(pilot,HttpStatus.OK);
    }

    @PostMapping("/regist")
    public ResponseEntity <String> registPilot(@RequestBody Pilot newPilot) {
        this.pilotService.registPilot(newPilot);
        return new ResponseEntity<>("Pilot Created",HttpStatus.CREATED);
    }
}
