package com.demo.demo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


//TODO: 1.1 Create API Gateway project
//TODO: 2. Enable Self registration with @EnableDiscoveryClient annotation
@SpringBootApplication
@EnableDiscoveryClient
public class DemoApiGateway {

	public static void main(String[] args) {
		SpringApplication.run(DemoApiGateway.class, args);
	}

}
