package com.cesardiaz.backend.f1.backendf1.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.cesardiaz.backend.f1.backendf1.components.ResultRaceConverterDTO;
import com.cesardiaz.backend.f1.backendf1.dtos.RecordFastlapDTO;
import com.cesardiaz.backend.f1.backendf1.dtos.ResultRaceDTO;
import com.cesardiaz.backend.f1.backendf1.models.Circuit;
import com.cesardiaz.backend.f1.backendf1.models.CodeValue;
import com.cesardiaz.backend.f1.backendf1.models.DriverFormulaOne;
import com.cesardiaz.backend.f1.backendf1.models.RecordFastLap;
import com.cesardiaz.backend.f1.backendf1.models.ResultRace;
import com.cesardiaz.backend.f1.backendf1.models.ScheduleGranPrix;
import com.cesardiaz.backend.f1.backendf1.repositories.CircuitRepository;
import com.cesardiaz.backend.f1.backendf1.repositories.CodeValueRepository;
import com.cesardiaz.backend.f1.backendf1.repositories.DriverFormulaRepository;
import com.cesardiaz.backend.f1.backendf1.repositories.ScheduleGrandPrixRepository;
import com.cesardiaz.backend.f1.backendf1.utils.validation.ResultRaceValidationRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ResultRaceServiceImp implements ResultRaceService{

    private final ResultRaceConverterDTO resultRaceConverterDTO;
    private final ResultRaceValidationRequest resultRaceValidationParam;
    private final DriverFormulaRepository driverRepository;
    private final CircuitRepository circuitRepository;
    private final CodeValueRepository codeValueRepository;
    private final ScheduleGrandPrixRepository grandPrixRepository;

    public ResultRaceServiceImp(ResultRaceConverterDTO resultRaceConverterDTO, ResultRaceValidationRequest resultRaceValidationParam, DriverFormulaRepository driverRepository, CircuitRepository circuitRepository, CodeValueRepository codeValueRepository, ScheduleGrandPrixRepository grandPrixRepository){
        this.resultRaceConverterDTO = resultRaceConverterDTO;
        this.resultRaceValidationParam = resultRaceValidationParam;
        this.driverRepository = driverRepository;
        this.circuitRepository = circuitRepository;
        this.codeValueRepository = codeValueRepository;
        this.grandPrixRepository = grandPrixRepository;

    }

    @Override
    public ResultRaceDTO getResultRaceById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResultRaceById'");
    }

    @Override
    public Page<ResultRaceDTO> getResultsRaceByDriver(Long driverId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResultsRaceByDriver'");
    }

    @Override
    public Page<ResultRaceDTO> getResultsRaceCustom(String command, Map<String, String> map) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResultsRaceCustom'");
    }

    @Override
    public String deleteResultRace(Long resultRaceId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteResultRace'");
    }

    @Override
    public ResultRaceDTO createResultRace(Map<String, String> mapRequest, Long driverId) {
        // TODO Auto-generated method stub
        return null;

    }

    private ResultRace createResultRace(Map<String, String> mapRequest){
        if(mapRequest != null && resultRaceValidationParam.validateParamToCreate(mapRequest)){
            Double points = Double.parseDouble(mapRequest.get("points"));
            Boolean dnf = Boolean.parseBoolean(mapRequest.get("dnf"));
            Boolean dns = Boolean.parseBoolean(mapRequest.get("dns"));
            Boolean dnq = Boolean.parseBoolean(mapRequest.get("dnq"));
            Long driverId = Long.parseLong(mapRequest.get("driverId"));
            Long scheduleGranPrixId = Long.parseLong(mapRequest.get("scheduleGranPrixId"));
            String recordFastLapString = mapRequest.get("recordFastLap");
            BigDecimal recordFastLapNumber = new BigDecimal(recordFastLapString);
            
            Long circuitId = Long.parseLong(mapRequest.get("circuitId"));
            Long codeValueSeassonId = Long.parseLong(mapRequest.get("codeValueSeassonId"));
            Integer status = Integer.parseInt(mapRequest.get("status"));
            try {


                LocalDate date = LocalDate.now();
                
                Optional<DriverFormulaOne> driverExist = driverRepository.findById(driverId);
                
                Optional<Circuit> circuitExist = circuitRepository.findById(circuitId);
                Optional<CodeValue> codeValueSeassonExist = codeValueRepository.findById(codeValueSeassonId);
                Optional<ScheduleGranPrix> grandPrixRepositoryExist = grandPrixRepository.findById(scheduleGranPrixId);

                if(!driverExist.isPresent() || !circuitExist.isPresent() || !codeValueSeassonExist.isPresent() || !grandPrixRepositoryExist.isPresent()){
                    throw new RuntimeException("ERROR EN LA PETICION");
                }

                RecordFastLap recordFastLap = RecordFastLap.instance(recordFastLapString, circuitExist.get(), codeValueSeassonExist.get(), status, date, null);

                ResultRace resultRace = ResultRace.instance(points, dnf, dns, dnq, recordFastLap, date, null, driverExist.get(), grandPrixRepositoryExist.get());
                return resultRace;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

}
