package com.cjeronimo.demo.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


//TODO: 2. Add properties into config repository for actuator(demo-passenger-service/application-work.yml)
//TODO: 3. Run this service and validate with URL http://127.0.0.1:4041/demo/actuator
//TODO: 5. Test Metrics server using http://127.0.0.1:4080/wallboard url
@SpringBootApplication
@EnableDiscoveryClient
public class DemoPassengerService {

	public static void main(String[] args) {
		SpringApplication.run(DemoPassengerService.class, args);
	}

}
