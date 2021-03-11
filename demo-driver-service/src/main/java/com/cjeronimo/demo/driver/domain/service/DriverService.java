package com.cjeronimo.demo.driver.domain.service;


import com.cjeronimo.demo.driver.adapter.outbound.sql.DriverRepository;
import com.cjeronimo.demo.driver.domain.model.entity.DriverEntity;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@CommonsLog
public class DriverService implements  IDriverService{
    private DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }


    @Override
    public Optional<DriverEntity> readDriver(long driverId) {
        log.info("Get info for driver: " + driverId);
        return driverRepository.findById(driverId);
    }


    @Override
    public long createDriver(DriverEntity driver) {
        log.info("Create new driver: " + driver);
        Optional<DriverEntity> entity = driverRepository.findByFullNameAndGender(
                driver.getFullName(),
                driver.getGender());

        if(entity.isPresent()) {
            return entity.get().getId();
        }
        return driverRepository.save(driver).getId();
    }
}
