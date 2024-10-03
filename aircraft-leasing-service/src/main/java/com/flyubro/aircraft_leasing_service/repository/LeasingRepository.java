package com.flyubro.aircraft_leasing_service.repository;

import com.flyubro.aircraft_leasing_service.model.Leasing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeasingRepository extends JpaRepository<Leasing,Long> {

}
