package com.cjeronimo.demo.passenger.domain.service;


import com.cjeronimo.demo.passenger.adapter.outbound.sql.PassengerRepository;
import com.cjeronimo.demo.passenger.domain.model.entity.PassengerEntity;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


//TODO: 9.1 Delete Passengers's list and driver instance
//TODO: 9.2 Implement repository calls for read and create methods
@Service
@CommonsLog
public class PassengerService implements IPassengerService {
    private PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }


    @Override
    public Optional<PassengerEntity> readPassenger(long passengerId) {
        log.info("Get info for passenger: " + passengerId);
        return passengerRepository.findById(passengerId);
    }

    @Override
    public long createPassenger(PassengerEntity passenger) {
        log.info("Create new passenger: " + passenger);
        Optional<PassengerEntity> entity = passengerRepository.findByFullNameAndGenderAndEmail(
                passenger.getFullName(),
                passenger.getGender(),
                passenger.getEmail());

        if(entity.isPresent()) {
            return entity.get().getId();
        }
        return passengerRepository.save(passenger).getId();
    }
}
