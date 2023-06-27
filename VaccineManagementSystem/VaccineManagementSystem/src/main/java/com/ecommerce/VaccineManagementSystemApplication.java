package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.ecommerce.controllers","com.ecommerce.entity", "com.ecommerce.repository" })
@SpringBootApplication

public class VaccineManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccineManagementSystemApplication.class, args);
	}

}
