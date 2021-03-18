package com.cjeronimo.demo.driver.domain.model.entity;

import com.cjeronimo.demo.driver.domain.catalog.Travel;
import com.cjeronimo.demo.driver.domain.model.vo.AddressVO;
import com.cjeronimo.demo.driver.domain.model.vo.DriverVO;
import com.cjeronimo.demo.driver.domain.model.vo.PassengerVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity(name = "TRIP")
@Table(name = "TRIP")
public class TripEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    //TODO: 3.2 Avoid return these Ids in json response
    @JsonIgnore
    private long driverId;
    @JsonIgnore
    private long passengerId;
    @Enumerated(EnumType.STRING)
    private Travel travel;
    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "latitude", column = @Column(name = "origin_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "origin_longitude"))})
    private AddressVO origin;
    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "latitude", column = @Column(name = "destination_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "destination_longitude"))})
    private AddressVO destination;
    private double fee;
    private LocalDateTime requestedAt = LocalDateTime.now();


    //TODO: 3.1 Add Driver and Passenger properties but avoid persist into DB
    @Transient
    private DriverVO driver;
    @Transient
    private PassengerVO passenger;
}
