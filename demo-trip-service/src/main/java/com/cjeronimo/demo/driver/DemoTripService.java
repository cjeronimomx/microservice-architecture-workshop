package com.cjeronimo.demo.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

//TODO: 2. Enable Hystrix and Hystrix-dashbooard
//TODO: 4. Restart this microservice and test shutdown driver-service or passenger-service
//TODO: 5 Review Hystrix dashboard en http://127.0.0.1:4042/demo/hystrix URL and use http://127.0.0.1:4042/demo/actuator/hystrix.stream as Stream
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class DemoTripService {

	public static void main(String[] args) {
		SpringApplication.run(DemoTripService.class, args);
	}

}
