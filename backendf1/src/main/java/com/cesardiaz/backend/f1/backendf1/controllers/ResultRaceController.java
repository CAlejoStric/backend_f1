package com.cesardiaz.backend.f1.backendf1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesardiaz.backend.f1.backendf1.dtos.ResultRaceDTO;
import com.cesardiaz.backend.f1.backendf1.services.ResultRaceService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
@Tag(name = "ResultRace", description = "Service manages result races of a race by f1 driver.")
public class ResultRaceController {

    private final ResultRaceService resultRaceService;

    public ResultRaceController(ResultRaceService resultRaceService){
        this.resultRaceService = resultRaceService;

    }

    @PostMapping("path")
    public ResultRaceDTO post(@RequestBody Map<String, String> mapRequest) {
        //TODO: process POST request
        
        return null;
    }
    
}
