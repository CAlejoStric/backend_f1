package com.cesardiaz.backend.f1.backendf1.components;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.cesardiaz.backend.f1.backendf1.dtos.RecordFastlapDTO;
import com.cesardiaz.backend.f1.backendf1.models.RecordFastLap;

@Component
public class RecordFastLapConverterDTO {


    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    public RecordFastLap convertDtoToEntity(RecordFastlapDTO recordFastlapDTO){

            return RecordFastLap.instance(recordFastlapDTO.getRecordFastLap(), null, null, 1, LocalDate.now(), null);
    }

    // public RecordFastlapDTO convertEntityToDto(RecordFastLap recordFastlap){
    //     RecordFastlapDTO recordFastlapDTO = new RecordFastlapDTO(recordFastlap.getRecordFastLap(), recordFastlap, null, null, null, null, null);
    // }
}
