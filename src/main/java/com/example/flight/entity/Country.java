package com.example.flight.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="country_info")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="c_id")
    private int cId;

    @Column(name="from_country")
    private String from_country;

    @Column(name="to_country")
    private String to_country;

}
