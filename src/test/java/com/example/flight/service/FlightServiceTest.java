package com.example.flight.service;

import com.example.flight.entity.FlightInfo;
import com.example.flight.repo.FlightRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {

    @Mock
    private FlightRepo flightRepo;

    @InjectMocks
    private FlightService flightService;

    @Test
    public void testListAllFlights(){
        List<FlightInfo> flightInfoList = new ArrayList<FlightInfo>();
        when(flightRepo.findAll()).thenReturn(flightInfoList);
        Assertions.assertDoesNotThrow(() -> flightService.listAllFlights());
    }

    @Test
    public void testSaveFlight(){
        FlightInfo flightInfo = new FlightInfo();
        when(flightRepo.save(any())).thenReturn(flightInfo);
        Assertions.assertDoesNotThrow(() -> flightService.save(flightInfo));
    }
}
