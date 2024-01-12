package com.example.flight.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="flight_info")
public class FlightInfo implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="f_id")
    private int fId;

    @Column(name="f_name")
    private String fName;

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name = "f_id",referencedColumnName="f_id")
    List<Country> countryList;

}
