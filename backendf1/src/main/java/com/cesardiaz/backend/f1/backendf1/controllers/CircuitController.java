package com.cesardiaz.backend.f1.backendf1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cesardiaz.backend.f1.backendf1.dtos.CircuitDTO;
import com.cesardiaz.backend.f1.backendf1.services.CircuitService;
import com.cesardiaz.backend.f1.backendf1.utils.CircuitCommandEnum;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@Tag(name = "Circuit", description = "Service where can manages diferents kind of services as CRUD of the sircuits of seasson.")
@RequestMapping("/api")
public class CircuitController {

    private final CircuitService circuitService;


    public CircuitController(CircuitService circuitService){
        this.circuitService = circuitService;
        
    }

    @PostMapping("/circuits")
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Create a new F1 Driver.", description = "This endpoint save a new driver if does not exist.")
    public ResponseEntity<Page<CircuitDTO>> getAll(@RequestParam(name = "command", defaultValue = "circuits_available") Optional<CircuitCommandEnum> command, 
    @RequestParam(name = "page", defaultValue = "0") int page,
    @RequestParam(name = "size", defaultValue = "1") int size) {
        //TODO: process POST request
        
        return circuitService.getAllCircuits(command.get().getCode(), page, size);
    }
    
}
