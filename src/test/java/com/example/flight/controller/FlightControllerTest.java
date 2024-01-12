package com.example.flight.controller;

import com.example.flight.entity.FlightInfo;
import com.example.flight.service.FlightService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FlightController.class)
public class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    FlightService flightService;

    @Test
    public void testGetAllFlights() throws Exception {
        when(flightService.listAllFlights()).thenReturn(new ArrayList<>());
        this.mockMvc.perform(get("/flights")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void testAddFlights() throws Exception {
        String requestBody = "{  \"countryList\": [    {      \"from_country\": \"pune\",      \"to_country\": \"mumbai\"    },     {      \"from_country\": \"delhi\",      \"to_country\": \"banglore\"    }  ],  \"fname\": \"Indigo\"}";
        when(flightService.save(any())).thenReturn(new FlightInfo());
        this.mockMvc.perform(post("/flights") .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)).andDo(print()).andExpect(status().isCreated());

    }
}
