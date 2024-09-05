package com.cesardiaz.backend.f1.backendf1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cesardiaz.backend.f1.backendf1.models.ScheduleGranPrix;

@Repository
public interface ScheduleGrandPrixRepository extends JpaRepository<ScheduleGranPrix, Long>{

}
