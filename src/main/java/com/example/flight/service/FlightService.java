package com.example.flight.service;

import com.example.flight.entity.FlightInfo;
import com.example.flight.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepo flightRepo;

    public List<FlightInfo> listAllFlights() {
        return flightRepo.findAll();
    }

    public FlightInfo save(FlightInfo flightInfo) {
        return flightRepo.save(flightInfo);
    }

}
