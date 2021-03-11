package com.cjeronimo.demo.driver.adapter.inbound.rest.controller;


import com.cjeronimo.demo.driver.adapter.inbound.rest.payload.ResponseDTO;
import com.cjeronimo.demo.driver.domain.model.entity.TripEntity;
import com.cjeronimo.demo.driver.domain.service.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/trips")
public class TripController {
    private ITripService tripService;


    @Autowired
    public TripController(ITripService tripService) {
        this.tripService = tripService;
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponseDTO<TripEntity>> get(@PathVariable("id") long tripId) {
        Optional<TripEntity> trip = tripService.readTrip(tripId);

        if (trip.isPresent()) {
            return ResponseEntity
                    .ok(ResponseDTO.ok("Trip queried successful", trip.get()));
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ResponseDTO.nok(HttpStatus.NOT_FOUND, "Trip does not exists"));
        }

    }


    @PostMapping(path = "/")
    public ResponseEntity<ResponseDTO<Long>> add(@RequestBody TripEntity trip) {
        long tripId = tripService.createTrip(trip);
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{tripId}")
                        .buildAndExpand(tripId)
                        .toUri()
        ).body(ResponseDTO.ok("Trip created successful", tripId));
    }
}
