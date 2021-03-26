package com.cjeronimo.demo.metrics;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//TODO: 0.1 Rename this class with DemoMetricsServer
//TODO: 2. Create folder and file demo-metrics-server/application-work.yml into config-properties project and configure service discovery properties for self registration
//TODO: 3. Annotate this class with @EnableAdminServer
//TODO: 4. Configure each business service with client dependency and properties
//TODO: 5. Test Application metrics dashboard http://127.0.0.1:4080/wallboard
@SpringBootApplication
@EnableAdminServer
public class DemoMetricsServer {

	public static void main(String[] args) {
		SpringApplication.run(DemoMetricsServer.class, args);
	}

}
