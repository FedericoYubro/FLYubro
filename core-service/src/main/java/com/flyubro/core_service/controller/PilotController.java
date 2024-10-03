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
            return new ResponseEntity<>(pilotList,HttpStatus.NO_CONTENT);//204 no es error
        } else {
            return new ResponseEntity<>(pilotList,HttpStatus.OK);
        }
    }



    @Operation(summary = "Crea un nuevo producto", description = "Permite la creación de un nuevo producto en el sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Producto creado con éxito", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "409", description = "Conflicto, el producto ya existe.", content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/regist")
    public ResponseEntity <String> registPilot(@RequestBody Pilot newPilot) {//con el request body le exijo todos los valores de la entidad
        this.pilotService.registPilot(newPilot);
        return new ResponseEntity<>("Pilot Created",HttpStatus.CREATED);
    }
}
