package com.sample.springapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Punto de entrada, con el @SpringBootApplication le indica a Spring el punto de entrada
@SpringBootApplication
public class SampleSpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringApiApplication.class, args);
	}

}
