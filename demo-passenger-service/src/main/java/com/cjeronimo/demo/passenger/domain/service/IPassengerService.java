package com.cjeronimo.demo.passenger.domain.service;

import com.cjeronimo.demo.passenger.domain.model.entity.PassengerEntity;

import java.util.Optional;

public interface IPassengerService {
    Optional<PassengerEntity> readPassenger(long passengerId);
    long createPassenger(PassengerEntity passenger);
}
