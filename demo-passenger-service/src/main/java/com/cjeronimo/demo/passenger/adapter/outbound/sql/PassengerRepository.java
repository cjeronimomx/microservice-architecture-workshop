package com.cjeronimo.demo.passenger.adapter.outbound.sql;

import com.cjeronimo.demo.passenger.domain.catalog.Gender;
import com.cjeronimo.demo.passenger.domain.model.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//TODO: 8.1 Create outbound.sql package
//TODO: 8.2 Create PassengerRepository repository
//TODO 8.3 Implement findByFullNameAndGenderAndCarId method
@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {
    Optional<PassengerEntity> findByFullNameAndGenderAndEmail(String fullName, Gender gender, String email);
}
