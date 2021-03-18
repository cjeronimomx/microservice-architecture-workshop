package com.demo.demo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DemoConfigServer {

	public static void main(String[] args) {
		SpringApplication.run(DemoConfigServer.class, args);
	}

}
