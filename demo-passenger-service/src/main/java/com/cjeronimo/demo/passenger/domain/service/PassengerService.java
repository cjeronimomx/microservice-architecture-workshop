package com.cjeronimo.demo.passenger.domain.service;


import com.cjeronimo.demo.passenger.domain.catalog.Gender;
import com.cjeronimo.demo.passenger.domain.model.entity.PassengerEntity;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@CommonsLog
public class PassengerService implements IPassengerService {
    private List<PassengerEntity> passengers;


    public PassengerService() {
        this.passengers = new ArrayList<>();
        passengers.add(
            PassengerEntity.builder()
                    .id(1)
                    .fullName("Melinda Ann French")
                    .gender(Gender.FEMALE)
                    .phoneNumber("5512345678")
                    .email("melinda@microsoft.com")
                    .build()
        );
    }


    @Override
    public Optional<PassengerEntity> readPassenger(long passengerId) {
        log.info("Get info for passenger: " + passengerId);
        return passengers.stream()
                .filter(passenger -> passenger.getId() == passengerId)
                .findFirst();
    }

    @Override
    public long createPassenger(PassengerEntity passenger) {
        log.info("Create new passenger: " + passenger);
        if(!readPassenger(passenger.getId()).isPresent()) {
            passengers.add(passenger);
            return passenger.getId();
        }
        return 0;
    }
}
