package com.example.FleetManagementDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:env.properties")
public class FleetManagementDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetManagementDemoApplication.class, args);
	}

}
