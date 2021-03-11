package com.cjeronimo.demo.driver.adapter.outbound.sql;

import com.cjeronimo.demo.driver.domain.catalog.Travel;
import com.cjeronimo.demo.driver.domain.model.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<TripEntity, Long> {
    Optional<TripEntity> findByDriverIdAndPassengerIdAndTravel(long driverId, long passengerId, Travel travel);
}
