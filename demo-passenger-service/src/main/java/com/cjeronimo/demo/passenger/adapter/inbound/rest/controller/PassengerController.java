package com.cjeronimo.demo.passenger.adapter.inbound.rest.controller;


import com.cjeronimo.demo.passenger.adapter.inbound.rest.payload.ResponseDTO;
import com.cjeronimo.demo.passenger.domain.model.entity.PassengerEntity;
import com.cjeronimo.demo.passenger.domain.service.IPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/passengers")
public class PassengerController {
    private IPassengerService passengerService;


    @Autowired
    public PassengerController(IPassengerService passengerService) {
        this.passengerService = passengerService;
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponseDTO<PassengerEntity>> get(@PathVariable("id") long passengerId) {
        Optional<PassengerEntity> passenger = passengerService.readPassenger(passengerId);

        if (passenger.isPresent()) {
            return ResponseEntity
                    .ok(ResponseDTO.ok("Passenger queried successful", passenger.get()));
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ResponseDTO.nok(HttpStatus.NOT_FOUND, "Passenger does not exists"));
        }

    }


    @PostMapping(path = "/")
    public ResponseEntity<ResponseDTO<Long>> add(@RequestBody PassengerEntity passenger) {
        long passengerId = passengerService.createPassenger(passenger);
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{passengerId}")
                        .buildAndExpand(passengerId)
                        .toUri()
        ).body(ResponseDTO.ok("Passenger registered successful", passengerId));
    }
}
