package com.yoursustainabledelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "Store")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Store {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private String name;

    private int area;

    private String street;

    @Column(name = "snumber")
    private String number;

    private String city;

    private String postalCode;



    private int  accesories;



    private int  drinks;



    private int  foods;



    private int  bigHouseHoldGoods;



    private int  smallHouseHoldGoods;



    private int  rtv;



    private int  smallElectronics;



    private int  computers;


}
