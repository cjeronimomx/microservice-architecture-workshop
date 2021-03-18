package com.demo.demo.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


//TODO: 0.1 Rename this class with DemoServiceDiscovery name
//TODO: 1.0 Create new spring cloud project with eureka-server and config client dependencies
//TODO: 2. Annotate this class with @EnableEurekaServer
//TODO: 5.1 Run with work profile

@SpringBootApplication
@EnableEurekaServer
public class DemoServiceDiscovery {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceDiscovery.class, args);
	}

}
