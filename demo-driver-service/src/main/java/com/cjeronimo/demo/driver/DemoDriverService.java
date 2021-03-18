package com.cjeronimo.demo.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class DemoDriverService {
	public static void main(String[] args) {
		SpringApplication.run(DemoDriverService.class, args);
	}

}
