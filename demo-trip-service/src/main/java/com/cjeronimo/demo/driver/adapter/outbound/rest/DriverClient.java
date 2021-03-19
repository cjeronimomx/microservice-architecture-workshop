package com.cjeronimo.demo.driver.adapter.outbound.rest;


import com.cjeronimo.demo.driver.adapter.inbound.rest.payload.ResponseDTO;
import com.cjeronimo.demo.driver.adapter.outbound.rest.fallback.DriverHystrixFallback;
import com.cjeronimo.demo.driver.domain.model.vo.DriverVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//TODO: 3.3 Add fallback argurment with DriverHystrixFallback.class value
@FeignClient(name = "DEMO-DRIVER-SERVICE", fallback = DriverHystrixFallback.class)  // DEMO-DRIVER-SERVICE is the name that the service discovery have been registered
public interface DriverClient {
    @GetMapping(path = "/demo/api/v1/drivers/{id}")
    ResponseEntity<ResponseDTO<DriverVO>> get(@PathVariable("id") long driverId);
}
