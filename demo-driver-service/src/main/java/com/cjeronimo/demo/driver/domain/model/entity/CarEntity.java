package com.cjeronimo.demo.driver.domain.model.entity;


import com.cjeronimo.demo.driver.domain.catalog.Color;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Builder
@Getter
@ToString
public class CarEntity {
    private long id;
    private String brand;
    private String model;
    private String numberPlate;
    private Color color;
}
