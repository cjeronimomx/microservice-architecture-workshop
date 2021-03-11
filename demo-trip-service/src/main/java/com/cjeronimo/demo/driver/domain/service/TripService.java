package com.cjeronimo.demo.driver.domain.service;


import com.cjeronimo.demo.driver.adapter.outbound.sql.TripRepository;
import com.cjeronimo.demo.driver.domain.model.entity.TripEntity;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@CommonsLog
public class TripService implements ITripService {
    private TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }


    @Override
    public Optional<TripEntity> readTrip(long tripId) {
        log.info("Get info for trip: " + tripId);
        return tripRepository.findById(tripId);
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
