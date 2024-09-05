package com.cesardiaz.backend.f1.backendf1.components;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.cesardiaz.backend.f1.backendf1.dtos.CircuitDTO;
import com.cesardiaz.backend.f1.backendf1.dtos.RecordFastlapDTO;
import com.cesardiaz.backend.f1.backendf1.dtos.ResultRaceDTO;
import com.cesardiaz.backend.f1.backendf1.models.Circuit;
import com.cesardiaz.backend.f1.backendf1.models.RecordFastLap;
import com.cesardiaz.backend.f1.backendf1.models.ResultRace;

@Component
public class ResultRaceConverterDTO {

    public ResultRace convertDtoToEntity(ResultRaceDTO resultRaceDTO){

        RecordFastLap recordFastLap = null;
        if(resultRaceDTO.getRecordFastlap()!=null){
            RecordFastlapDTO recordFastlapDTO = resultRaceDTO.getRecordFastlap();
            recordFastLap = RecordFastLap.instance(recordFastlapDTO.getRecordFastLap(), null, null, 1, LocalDate.now(), null);
        }

        return ResultRace.instance(resultRaceDTO.getPoints(), resultRaceDTO.getDnf(), resultRaceDTO.getDns(), resultRaceDTO.getDnq(), recordFastLap, LocalDate.now(), null, null, null);
    }
}
