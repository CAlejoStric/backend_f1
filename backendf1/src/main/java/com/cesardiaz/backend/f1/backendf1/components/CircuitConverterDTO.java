package com.cesardiaz.backend.f1.backendf1.components;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.cesardiaz.backend.f1.backendf1.dtos.CircuitDTO;
import com.cesardiaz.backend.f1.backendf1.dtos.CodeValueDto;
import com.cesardiaz.backend.f1.backendf1.dtos.RecordFastlapDTO;
import com.cesardiaz.backend.f1.backendf1.models.Circuit;

@Component
public class CircuitConverterDTO {

    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

    public CircuitDTO convertEntityToDto(Circuit circuit) {
        String dateCreated = null;
        String dateUpdated = null;
        if (circuit.getDateCreated() != null) {

            dateCreated = circuit.getDateCreated().format(formatter);
        }
        if (circuit.getDateUpdated() != null) {

            dateUpdated = circuit.getDateUpdated().format(formatter);
        }
        CodeValueDto codeValueSeassonDto = null;
        if (circuit.getCodeValueCountry() != null) {

            codeValueSeassonDto = new CodeValueDto(circuit.getCodeValueCountry().getId(),
                    circuit.getCodeValueCountry().getCodeValue(), circuit.getCodeValueCountry().getCode().getId());

        }
        RecordFastlapDTO recordFastlapDTO = null;
        if (circuit.getRecordFastLap() != null) {
            String dateCreatedRecordFastlap = circuit.getRecordFastLap().getDatecreated().format(formatter);
            String dateUpdatedRecordFastlap = circuit.getRecordFastLap().getDatecreated().format(formatter);
            recordFastlapDTO = new RecordFastlapDTO(circuit.getRecordFastLap().getRecordFastLap(), null, null,
                    circuit.getRecordFastLap().getStatus(), dateCreatedRecordFastlap, dateUpdatedRecordFastlap);

        }

        CircuitDTO circuitDTO = new CircuitDTO(circuit.getName(), codeValueSeassonDto, dateCreated, dateUpdated,
                circuit.getNumberLaps(), recordFastlapDTO);
        return circuitDTO;
    }
}
