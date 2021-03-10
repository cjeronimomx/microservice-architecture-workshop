package com.cjeronimo.demo.driver.domain.model.entity;

import com.cjeronimo.demo.driver.domain.catalog.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Builder
@Getter
@ToString
public class DriverEntity {
    private long id;
    private String fullName;
    private Gender gender;
    private float rate;

    private CarEntity car;
}
