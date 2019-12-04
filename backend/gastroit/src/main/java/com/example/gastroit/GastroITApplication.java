package com.example.gastroit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GastroITApplication {

	public static void main(String[] args) {
		SpringApplication.run(GastroITApplication.class, args);
	}

}
