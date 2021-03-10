package com.cjeronimo.demo.driver.domain.service;

import com.cjeronimo.demo.driver.domain.model.entity.DriverEntity;

import java.util.Optional;

public interface IDriverService {
    Optional<DriverEntity> readDriver(long driverId);
    long createDriver(DriverEntity driver);
}
