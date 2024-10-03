package com.flyubro.core_service.repository;

import com.flyubro.core_service.model.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PilotRepository extends JpaRepository<Pilot,Long>{
    Optional<Pilot> findByLicenseNumber(long licenseNumber);
}
