package com.flyubro.aircraft_leasing_service.client;

import com.flyubro.aircraft_leasing_service.config.FeignClientConfig;
import com.flyubro.aircraft_leasing_service.model.Pilot;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient (name = "core-service",url = "http://localhost:8060/IU-C", configuration = FeignClientConfig.class)
public interface CoreClient {
    @GetMapping("/pilot/search")
    public ResponseEntity<Pilot> searchPilotByLicense(@RequestParam long licenseNumber);
}
