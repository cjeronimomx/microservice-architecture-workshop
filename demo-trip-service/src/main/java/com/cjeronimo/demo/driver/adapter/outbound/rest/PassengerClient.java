package com.cjeronimo.demo.driver.adapter.outbound.rest;


import com.cjeronimo.demo.driver.adapter.inbound.rest.payload.ResponseDTO;
import com.cjeronimo.demo.driver.domain.model.vo.PassengerVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "DEMO-PASSENGER-SERVICE")  // DEMO-DRIVER-SERVICE is the name that the service discovery have been registered
public interface PassengerClient {
    @GetMapping(path = "/demo/api/v1/passengers/{id}")
    ResponseEntity<ResponseDTO<PassengerVO>> get(@PathVariable("id") long passengerId);
}