package com.eacuji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.eacuji"})
public class CargadorSolarAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CargadorSolarAppApplication.class, args);
	}
}
