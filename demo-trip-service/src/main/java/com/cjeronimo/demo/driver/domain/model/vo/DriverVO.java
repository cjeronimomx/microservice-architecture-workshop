package com.cjeronimo.demo.driver.domain.model.vo;

import com.cjeronimo.demo.driver.domain.catalog.Gender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DriverVO {
    private long id;
    private String fullName;
    private Gender gender;
    private float rate;
    private CarVO car;
}
