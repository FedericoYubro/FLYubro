package com.flyubro.aircraft_leasing_service.repository;

import com.flyubro.aircraft_leasing_service.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft,Long> {

    @Query("SELECT a FROM Aircraft a where a.aircraftReg = :aircraftReg")
    Optional<Aircraft> findAircraftByRegistration(String aircraftReg);

}
