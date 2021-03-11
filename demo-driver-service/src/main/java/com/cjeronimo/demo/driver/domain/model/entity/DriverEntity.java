package com.cjeronimo.demo.driver.domain.model.entity;

import com.cjeronimo.demo.driver.domain.catalog.Gender;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "DRIVER")
@Table(name = "DRIVER")
public class DriverEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String fullName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private float rate;

    @OneToOne(cascade = CascadeType.ALL)
    private CarEntity car;
}
