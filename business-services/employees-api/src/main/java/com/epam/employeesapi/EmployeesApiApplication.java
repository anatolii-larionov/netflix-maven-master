package com.epam.employeesapi;

import com.epam.employeesapi.services.Sender;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.epam.commons"})
@EnableEurekaClient
@EntityScan("com.epam.commons.*")
@EnableIntegration
@RequiredArgsConstructor
public class EmployeesApiApplication  implements CommandLineRunner {
	private final Sender sender;

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApiApplication.class, args);
	}

	@Override
	public void run(String... strings) {
		sender.send("0000002");
	}

}
