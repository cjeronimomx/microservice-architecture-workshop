package com.demo.demo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


//TODO: 1.2 Add Sleuth dependency into driver, passenger and trip service
//TODO: 1.3 Run all services and test trip using the API Gateway
@SpringBootApplication
@EnableDiscoveryClient
public class DemoApiGateway {

	public static void main(String[] args) {
		SpringApplication.run(DemoApiGateway.class, args);
	}

}
