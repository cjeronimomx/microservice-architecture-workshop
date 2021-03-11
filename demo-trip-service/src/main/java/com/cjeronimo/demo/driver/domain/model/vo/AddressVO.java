package com.cjeronimo.demo.driver.domain.model.vo;

import lombok.Data;
import javax.persistence.Embeddable;


//TODO: 6.3 Mark AddressVO as @Embeddable to use composition in TripEntity class
@Data
@Embeddable
public class AddressVO {
    private double latitude;
    private double longitude;
}
