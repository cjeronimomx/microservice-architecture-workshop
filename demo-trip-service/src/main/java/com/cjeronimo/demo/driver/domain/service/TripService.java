package com.cjeronimo.demo.driver.domain.service;


import com.cjeronimo.demo.driver.domain.catalog.Travel;
import com.cjeronimo.demo.driver.domain.model.entity.TripEntity;
import com.cjeronimo.demo.driver.domain.model.vo.AddressVO;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@CommonsLog
public class TripService implements ITripService {
    private List<TripEntity> trips;


    public TripService() {
        this.trips = new ArrayList<>();
        trips.add(
            TripEntity.builder()
                    .id(1)
                    .driverId(1)
                    .passengerId(1)
                    .travel(Travel.PERSONAL)
                    .fee(20.5)
                    .origin(AddressVO.builder()
                            .longitude(19.42304968281519).latitude(-99.17478948779936)
                            .build())
                    .destination(AddressVO.builder()
                            .longitude(19.44188326518538).latitude(-99.18356656059463)
                            .build())
                    .build()
        );
    }


    @Override
    public Optional<TripEntity> readTrip(long tripId) {
        log.info("Get info for trip: " + tripId);
        return trips.stream()
                .filter(driver -> driver.getId() == tripId)
                .findFirst();
    }

    @Override
    public long createTrip(TripEntity trip) {
        log.info("Create new trip: " + trip);
        if(!readTrip(trip.getId()).isPresent()) {
            trips.add(trip);
            return trip.getId();
        }
        return 0;
    }
}
