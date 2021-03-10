package com.cjeronimo.demo.passenger.domain.model.entity;

import com.cjeronimo.demo.passenger.domain.catalog.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Builder
@Getter
@ToString
public class PassengerEntity {
    private long id;
    private String fullName;
    private Gender gender;
    private String phoneNumber;
    private String email;
}
