package com.cjeronimo.demo.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//TODO: 1.2 Enable feign client with @EnableFeignClients annotation
//TODO: 5. Restsart this microservice and test Get Trip Info
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DemoTripService {

	public static void main(String[] args) {
		SpringApplication.run(DemoTripService.class, args);
	}

}
