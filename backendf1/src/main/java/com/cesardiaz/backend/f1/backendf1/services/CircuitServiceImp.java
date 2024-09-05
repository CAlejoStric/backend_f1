package com.cesardiaz.backend.f1.backendf1.services;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cesardiaz.backend.f1.backendf1.components.CircuitConverterDTO;
import com.cesardiaz.backend.f1.backendf1.dtos.CircuitDTO;
import com.cesardiaz.backend.f1.backendf1.models.Circuit;
import com.cesardiaz.backend.f1.backendf1.models.CodeValue;
import com.cesardiaz.backend.f1.backendf1.repositories.CircuitRepository;
import com.cesardiaz.backend.f1.backendf1.repositories.CodeValueRepository;
import com.cesardiaz.backend.f1.backendf1.utils.CircuitCommandEnum;
import com.cesardiaz.backend.f1.backendf1.utils.ResponseEntityCustom;
import com.cesardiaz.backend.f1.backendf1.utils.validation.CircuitValidationRequest;

@Service
public class CircuitServiceImp implements CircuitService {

    private final CircuitRepository circuitRepository;
    private final CodeValueRepository codeValueRepository;
    private final CircuitConverterDTO circuitConverterDTO;

    public CircuitServiceImp(CodeValueRepository codeValueRepository, CircuitRepository circuitRepository,
            CircuitConverterDTO circuitConverterDTO) {
        this.circuitRepository = circuitRepository;
        this.codeValueRepository = codeValueRepository;
        this.circuitConverterDTO = circuitConverterDTO;

    }

    @Override
    public ResponseEntity<CircuitDTO> createNewCircuit(Map<String, Object> mapRequest) {
        // TODO Auto-generated method stub

        Circuit circuit = createCircuitEntity(mapRequest);

        if (circuit != null) {
            Circuit circuitSaved = circuitRepository.save(circuit);
            return ResponseEntity.ok().body(circuitConverterDTO.convertEntityToDto(circuitSaved));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<CircuitDTO> updateCircuit(Map<String, Object> mapRequest) {
        // TODO Auto-generated method stub
        if (mapRequest != null && CircuitValidationRequest.validationUpdateParam(mapRequest)) {
            Long id = (Long) mapRequest.get("id");

            Optional<Circuit> circuitOptional = circuitRepository.findById(id);

            if (circuitOptional.isPresent()) {
                Circuit circuitUpdate = circuitOptional.get();
                String name = (String) mapRequest.get("name");
                Long codeValueCountryId = (Long) mapRequest.get("codeValueCountry");
                
                Optional<CodeValue> codeValuseSeasson = codeValueRepository.findById(codeValueCountryId);

                if (name != null) {
                    circuitUpdate.setName(name);
                }
                if(codeValuseSeasson.isPresent()){
                    circuitUpdate.setCodeValueCountry(codeValuseSeasson.get());
                }

                return ResponseEntity.ok().body(circuitConverterDTO.convertEntityToDto(circuitUpdate));
            } else {

                return ResponseEntity.notFound().build();
            }

        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<String> deleteCircuit(Long circuitId) {
        // TODO Auto-generated method stub

        if(circuitId != null){

            Optional<Circuit> circuitOptional = circuitRepository.findById(circuitId);

            if(circuitOptional.isPresent()){
                Circuit circuit = circuitOptional.get();
                circuit.setIsDeleted(true);
                return ResponseEntityCustom.getResponseEntity("Cricuit Deleted", HttpStatus.ACCEPTED);
            }else{
                return ResponseEntity.notFound().build();
            }

        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    private Circuit createCircuitEntity(Map<String, Object> mapRequest) {

        if (mapRequest != null && CircuitValidationRequest.validationCreateParam(mapRequest)) {

            String name = (String) mapRequest.get("name");
            Long codeValueCountryId = (Long) mapRequest.get("codeValueCountry");
            Integer numberLaps = (Integer) mapRequest.get("numberLaps");

            Optional<CodeValue> codeValueCountryExist = codeValueRepository.findById(codeValueCountryId);

            if (!codeValueCountryExist.isPresent()) {
                throw new RuntimeException("Error al guardar el circuito");
            }

            return Circuit.instance(name, codeValueCountryExist.get(), LocalDate.now(), null, numberLaps, null);

        } else {
            return null;
        }
    }

    @Override
    public ResponseEntity<Page<CircuitDTO>> getAllCircuits(String command, int page, int size) {
        // TODO Auto-generated method stub
        if(command.equals(CircuitCommandEnum.circuits_available.getCode())){
            // Page<CircuitDTO> pageCircuits = circuitRepository.findAllCircuitAvailable(PageRequest.of(page, size, Sort.by("dateCreated")));
            return ResponseEntity.ok().body(null);
        }else if(command.equals(CircuitCommandEnum.circuits_seasson.getCode())){
            return null;
        }else{
            return ResponseEntity.badRequest().build();
        }
        
    }
}
