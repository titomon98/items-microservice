package com.msvc.items.items_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ItemsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemsMicroserviceApplication.class, args);
	}

}
