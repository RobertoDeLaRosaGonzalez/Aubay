package com.aubay.spaceships;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EntityScan("com.aubay.spaceships.Domain")
@EnableJpaRepositories("com.aubay.spaceships.Domain")
public class SpaceshipsApplication {

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpaceshipsApplication.class, args);
	}

}
