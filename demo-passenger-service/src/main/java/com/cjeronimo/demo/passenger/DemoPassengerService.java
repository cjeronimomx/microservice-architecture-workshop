package com.cjeronimo.demo.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//TODO: 2. Annotate this class with @EnableDiscoveryClient
//TODO: 3. Run with work profile and test GET and POST API methods
//TODO: 4. Validate instance registration in http://127.0.0.1:4060/demo/discovery/ url
@SpringBootApplication
@EnableDiscoveryClient
public class DemoPassengerService {

	public static void main(String[] args) {
		SpringApplication.run(DemoPassengerService.class, args);
	}

}
