package com.cjeronimo.demo.driver.domain.service;

import com.cjeronimo.demo.driver.domain.model.entity.TripEntity;

import java.util.Optional;

public interface ITripService {
    Optional<TripEntity> readTrip(long tripId);
    long createTrip(TripEntity trip);
}
