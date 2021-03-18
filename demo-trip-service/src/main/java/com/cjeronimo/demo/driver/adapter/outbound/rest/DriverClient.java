package com.cjeronimo.demo.driver.adapter.outbound.rest;


import com.cjeronimo.demo.driver.adapter.inbound.rest.payload.ResponseDTO;
import com.cjeronimo.demo.driver.domain.model.vo.DriverVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//TODO: 2.1 Create com.cjeronimo.demo.driver.adapter.outbound.rest package
//TODO: 2.2 Create DriverClient Interface and annotate with @FeignClient
//TODO: 2.3 Implement REST GET method
@FeignClient(name = "DEMO-DRIVER-SERVICE")  // DEMO-DRIVER-SERVICE is the name that the service discovery have been registered
public interface DriverClient {
    @GetMapping(path = "/demo/api/v1/drivers/{id}")
    ResponseEntity<ResponseDTO<DriverVO>> get(@PathVariable("id") long driverId);
}
