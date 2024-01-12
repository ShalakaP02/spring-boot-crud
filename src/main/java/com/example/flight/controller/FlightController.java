package com.example.flight.controller;

import com.example.flight.entity.FlightInfo;
import com.example.flight.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController {

    Logger log = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    FlightService flightService;

    @GetMapping("/flights")
    public ResponseEntity<List<FlightInfo>> getAllFlights(){
        log.info(" FlightController - getAllFlights.. ");
        List<FlightInfo> flightInfoList = flightService.listAllFlights();
        return new ResponseEntity<>(flightInfoList, HttpStatus.OK);

    }

    @PostMapping("/flights")
    public ResponseEntity<HttpStatus> addFlight(@RequestBody FlightInfo flightInfo){
        log.info(" FlightController - addFlight {}",flightInfo);
        flightService.save(flightInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
