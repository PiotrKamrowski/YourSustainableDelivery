package com.yoursustainabledelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "store")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Store {

    @Id
    @GeneratedValue
    private long id;


    private String name;


    private int area;


    private String street;


    private String number;

    private String City;


    private String postalCode;


    @Enumerated(EnumType.STRING)
    private ProductsRange  accesories;


    @Enumerated(EnumType.STRING)
    private ProductsRange  drinks;


    @Enumerated(EnumType.STRING)
    private ProductsRange  foods;


    @Enumerated(EnumType.STRING)
    private ProductsRange  bigHouseHoldGoods;


    @Enumerated(EnumType.STRING)
    private ProductsRange  smallHouseHoldGoods;


    @Enumerated(EnumType.STRING)
    private ProductsRange  rtv;


    @Enumerated(EnumType.STRING)
    private ProductsRange  smallElectronics;


    @Enumerated(EnumType.STRING)
    private ProductsRange  computers;


}
