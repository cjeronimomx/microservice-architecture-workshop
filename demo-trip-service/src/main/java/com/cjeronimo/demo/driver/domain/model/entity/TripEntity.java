package com.cjeronimo.demo.driver.domain.model.entity;

import com.cjeronimo.demo.driver.domain.catalog.Travel;
import com.cjeronimo.demo.driver.domain.model.vo.AddressVO;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Builder
@Getter
@ToString
public class TripEntity {
    private long id;
    private long driverId;
    private long passengerId;
    private Travel travel;
    private AddressVO origin;
    private AddressVO destination;
    private double fee;
}
