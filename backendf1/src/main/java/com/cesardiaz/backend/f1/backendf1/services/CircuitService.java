package com.cesardiaz.backend.f1.backendf1.services;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cesardiaz.backend.f1.backendf1.dtos.CircuitDTO;

@Service
public interface CircuitService {
    ResponseEntity<CircuitDTO> createNewCircuit(Map<String, Object> mapRequest);
    
    ResponseEntity<CircuitDTO> updateCircuit(Map<String, Object> mapRequest);
    
    ResponseEntity<String> deleteCircuit(Long circuitId);

    ResponseEntity<Page<CircuitDTO>> getAllCircuits(String command, int page, int size);
    
}
