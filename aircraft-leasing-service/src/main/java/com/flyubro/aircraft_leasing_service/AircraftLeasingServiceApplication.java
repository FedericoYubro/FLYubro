package com.flyubro.aircraft_leasing_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AircraftLeasingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AircraftLeasingServiceApplication.class, args);
	}

}
