package com.cesardiaz.backend.f1.backendf1.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cesardiaz.backend.f1.backendf1.dtos.CircuitDTO;
import com.cesardiaz.backend.f1.backendf1.models.Circuit;

@Repository
public interface CircuitRepository extends JpaRepository<Circuit, Long> {

    // @Query(value = "SELECT new com.cesardiaz.backend.f1.backendf1.dtos.CicuitDTO(c.name, "+
    // "new com.cesardiaz.backend.f1.backendf1.dtos.CodeValueDto(c.codeValueCountry.id, c.codeValueCountry.codeValue, c.codeValueCountry.code.id ), c.numberLaps, "+
    // "new com.cesardiaz.backend.f1.backendf1.dtos.RecordFastlapDTO(c.recordFastLap.id, c.recordFastLap.recordFastLap,  new com.cesardiaz.backend.f1.backendf1.dtos.CodeValueDto(c.codeValueSeasson.id, c.codeValueSeasson.codeValue, c.codeValueSeasson.code.id ) , c.recordFastLap.status)) FROM Circuit c WHERE c.isDeleted = false", nativeQuery = false)
    // Page<CircuitDTO> findAllCircuitAvailable(Pageable pageable);
}
