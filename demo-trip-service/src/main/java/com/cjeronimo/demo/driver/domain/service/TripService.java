package com.cjeronimo.demo.driver.domain.service;


import com.cjeronimo.demo.driver.adapter.outbound.rest.DriverClient;
import com.cjeronimo.demo.driver.adapter.outbound.rest.PassengerClient;
import com.cjeronimo.demo.driver.adapter.outbound.sql.TripRepository;
import com.cjeronimo.demo.driver.domain.model.entity.TripEntity;
import com.cjeronimo.demo.driver.domain.model.vo.DriverVO;
import com.cjeronimo.demo.driver.domain.model.vo.PassengerVO;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@CommonsLog
public class TripService implements ITripService {
    private TripRepository tripRepository;
    private DriverClient driverClient;
    private PassengerClient passengerClient;

    @Autowired
    public TripService(TripRepository tripRepository, DriverClient driverClient, PassengerClient passengerClient) {
        this.tripRepository = tripRepository;
        this.driverClient = driverClient;
        this.passengerClient = passengerClient;
    }


    @Override
    public Optional<TripEntity> readTrip(long tripId) {
        log.info("Get info for trip: " + tripId);

        Optional<TripEntity> trip = tripRepository.findById(tripId);
        if (trip.isPresent()) {
            TripEntity tripEntity = trip.get();
            DriverVO driver = driverClient.get(tripEntity.getDriverId())
                    .getBody()
                    .getContent();
            tripEntity.setDriver(driver);

            PassengerVO passenger = passengerClient.get(tripEntity.getPassengerId())
                    .getBody()
                    .getContent();
            tripEntity.setPassenger(passenger);
        }
        return trip;
    }


    @Override
    public long createTrip(TripEntity trip) {
        log.info("Create new trip: " + trip);
        Optional<TripEntity> entity = tripRepository.findByDriverIdAndPassengerIdAndTravel(
                trip.getDriverId(),
                trip.getPassengerId(),
                trip.getTravel());

        if(entity.isPresent()) {
            return entity.get().getId();
        }
        return tripRepository.save(trip).getId();
    }
}
