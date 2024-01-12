package com.example.flight.repo;

import com.example.flight.entity.FlightInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<FlightInfo,Long> {
}
