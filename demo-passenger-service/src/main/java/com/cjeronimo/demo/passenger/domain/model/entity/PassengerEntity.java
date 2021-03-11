package com.cjeronimo.demo.passenger.domain.model.entity;

import com.cjeronimo.demo.passenger.domain.catalog.Gender;
import lombok.*;

import javax.persistence.*;


@Data
@Entity(name = "PASSENGER")
@Table(name = "PASSENGER")
public class PassengerEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String fullName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phoneNumber;
    private String email;
}
