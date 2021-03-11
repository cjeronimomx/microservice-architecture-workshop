package com.cjeronimo.demo.driver.domain.model.entity;

import com.cjeronimo.demo.driver.domain.catalog.Travel;
import com.cjeronimo.demo.driver.domain.model.vo.AddressVO;
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
    private long driverId;
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
}
