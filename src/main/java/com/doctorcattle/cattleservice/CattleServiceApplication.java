package com.doctorcattle.cattleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CattleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CattleServiceApplication.class, args);
	}

}
