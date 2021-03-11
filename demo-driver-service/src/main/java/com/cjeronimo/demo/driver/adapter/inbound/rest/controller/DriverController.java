package com.cjeronimo.demo.driver.adapter.inbound.rest.controller;


import com.cjeronimo.demo.driver.adapter.inbound.rest.payload.ResponseDTO;
import com.cjeronimo.demo.driver.domain.model.entity.DriverEntity;
import com.cjeronimo.demo.driver.domain.service.IDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/drivers")
public class DriverController {
    private IDriverService driverService;


    @Autowired
    public DriverController(IDriverService driverService) {
        this.driverService = driverService;
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponseDTO<DriverEntity>> get(@PathVariable("id") long driverId) {
        Optional<DriverEntity> driver = driverService.readDriver(driverId);

        if (driver.isPresent()) {
            return ResponseEntity
                    .ok(ResponseDTO.ok("Driver queried successful", driver.get()));
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ResponseDTO.nok(HttpStatus.NOT_FOUND, "Driver does not exists"));
        }

    }


    @PostMapping(path = "/")
    public ResponseEntity<ResponseDTO<Long>> add(@RequestBody DriverEntity driver) {
        long driverId = driverService.createDriver(driver);
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{driverId}")
                        .buildAndExpand(driverId)
                        .toUri()
        ).body(ResponseDTO.ok("Driver registered successful", driverId));
    }
}
