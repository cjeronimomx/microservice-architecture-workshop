package com.cjeronimo.demo.driver.domain.service;


import com.cjeronimo.demo.driver.domain.catalog.Color;
import com.cjeronimo.demo.driver.domain.catalog.Gender;
import com.cjeronimo.demo.driver.domain.model.entity.CarEntity;
import com.cjeronimo.demo.driver.domain.model.entity.DriverEntity;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@CommonsLog
public class DriverService implements  IDriverService{
    private List<DriverEntity> drivers;


    public DriverService() {
        this.drivers = new ArrayList<>();
        drivers.add(
            DriverEntity.builder()
                    .id(1)
                    .fullName("Mark Elliot Zuckerberg")
                    .gender(Gender.MALE)
                    .rate(4.5F)
                    .car(CarEntity.builder()
                            .id(1)
                            .brand("Tesla")
                            .model("X")
                            .numberPlate("1234 BCD")
                            .color(Color.RED)
                            .build())
                    .build()
        );
    }


    @Override
    public Optional<DriverEntity> readDriver(long driverId) {
        log.info("Get info for driver: " + driverId);
        return drivers.stream()
                .filter(driver -> driver.getId() == driverId)
                .findFirst();
    }

    @Override
    public long createDriver(DriverEntity driver) {
        log.info("Create new driver: " + driver);
        if(!readDriver(driver.getId()).isPresent()) {
            drivers.add(driver);
            return driver.getId();
        }
        return 0;
    }
}
