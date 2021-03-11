package com.cjeronimo.demo.driver.domain.model.vo;

import lombok.Data;
import javax.persistence.Embeddable;


@Data
@Embeddable
public class AddressVO {
    private double latitude;
    private double longitude;
}
