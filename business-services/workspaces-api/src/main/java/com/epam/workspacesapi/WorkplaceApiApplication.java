package com.epam.workspacesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WorkplaceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkplaceApiApplication.class, args);
	}

}
