package com.aubay.spaceships;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EntityScan("com.aubay.spaceships.domain")
@EnableJpaRepositories("com.aubay.spaceships.domain")
public class SpaceshipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceshipsApplication.class, args);
	}

}
