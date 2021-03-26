package com.cjeronimo.demo.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


//TODO: 2. Add properties into config repository for actuator(demo-trip-service/application-work.yml)
//TODO: 3. Run this service and validate with URL http://127.0.0.1:4042/demo/actuator
//TODO: 5. Test Metrics server using http://127.0.0.1:4080/wallboard url
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
