package com.cjeronimo.demo.driver.adapter.outbound.sql;

import com.cjeronimo.demo.driver.domain.catalog.Gender;
import com.cjeronimo.demo.driver.domain.model.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//TODO: 8.1 Create outbound.sql package
//TODO: 8.2 Create DriverRepository repository
//TODO 8.3 Implement findByFullNameAndGenderAndCarId method
@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long> {
    Optional<DriverEntity> findByFullNameAndGender(String fullName, Gender gender);
}
