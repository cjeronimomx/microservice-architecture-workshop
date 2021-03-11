package com.cjeronimo.demo.driver.domain.model.entity;


import com.cjeronimo.demo.driver.domain.catalog.Color;
import lombok.Data;
import javax.persistence.*;


//TODO: 6.1 Change Builder by default constructor
//TODO: 6.2 Add JPA annotations
@Data
@Entity(name = "CAR")
@Table(name = "CAR")
public class CarEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;
    private String numberPlate;
    @Enumerated(EnumType.STRING)
    private Color color;
}
