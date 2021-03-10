package com.cjeronimo.demo.driver.domain.model.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class AddressVO {
    private double latitude;
    private double longitude;
}
