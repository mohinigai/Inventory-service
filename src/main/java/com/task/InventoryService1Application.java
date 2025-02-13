package com.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryService1Application {

	public static void main(String[] args) {
		SpringApplication.run(InventoryService1Application.class, args);
	}

}
