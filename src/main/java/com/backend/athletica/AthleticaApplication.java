package com.backend.athletica;

import com.backend.athletica.service.FileStorage;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AthleticaApplication implements CommandLineRunner {

	@Resource
	FileStorage storageService;

	public static void main(String[] args) {
		SpringApplication.run(AthleticaApplication.class, args);
	}

	@Override
	public void run(String... arg) {
		storageService.init();
	}

}
