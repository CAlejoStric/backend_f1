package com.cesardiaz.backend.f1.backendf1.utils.validation;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ResultRaceValidationRequest {


    public boolean validateParamToCreate(Map<String, String> requestMap){

        if(requestMap.containsKey("points") && requestMap.containsKey("dnf") && requestMap.containsKey("dns")
        && requestMap.containsKey("dnq") && requestMap.containsKey("driverId") && requestMap.containsKey("scheduleGranPrixId") && requestMap.containsKey("recordFastLap")
        && requestMap.containsKey("circuitId") && requestMap.containsKey("codeValueSeassonId") && requestMap.containsKey("status")){
            return true;
        }else
        return false;
    }
}
