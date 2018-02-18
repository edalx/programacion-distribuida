package com.eacuji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.eacuji"})
public class PlantaLamparaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantaLamparaApplication.class, args);
	}
}
