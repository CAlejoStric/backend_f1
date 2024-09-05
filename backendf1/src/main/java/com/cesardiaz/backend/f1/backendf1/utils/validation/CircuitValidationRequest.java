package com.cesardiaz.backend.f1.backendf1.utils.validation;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CircuitValidationRequest {

    public static boolean validationCreateParam(Map<String, Object> requestMap){

        if(requestMap.containsKey("name") && requestMap.containsKey("codeValueCountry")){
            return true;
        }else
        return false;
    }

    public static boolean validationUpdateParam(Map<String, Object> requestMap){

        if(requestMap.containsKey("id") && requestMap.containsKey("name") && requestMap.containsKey("codeValueCountry")){
            return true;
        }else
        return false;
    }
}
