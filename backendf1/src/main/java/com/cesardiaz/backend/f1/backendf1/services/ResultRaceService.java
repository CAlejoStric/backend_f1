package com.cesardiaz.backend.f1.backendf1.services;

import java.util.Map;

import org.springframework.data.domain.Page;

import com.cesardiaz.backend.f1.backendf1.dtos.ResultRaceDTO;

public interface ResultRaceService {

    ResultRaceDTO createResultRace(Map<String, String> mapRequest, Long driverId);

    ResultRaceDTO getResultRaceById(Long id);

    Page<ResultRaceDTO> getResultsRaceByDriver(Long driverId);
    
    Page<ResultRaceDTO> getResultsRaceCustom(String command, Map<String, String> map);

    String deleteResultRace(Long resultRaceId);
}
