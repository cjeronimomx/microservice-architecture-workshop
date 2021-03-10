package com.cjeronimo.demo.driver.domain.model.vo;

import com.cjeronimo.demo.driver.domain.catalog.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Builder
@Getter
@ToString
public class PassengerVO {
    private long id;
    private String fullName;
    private Gender gender;
    private String phoneNumber;
    private String email;
}
