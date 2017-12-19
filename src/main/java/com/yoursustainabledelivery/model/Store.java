package com.yoursustainabledelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "store")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Store {

    @Id
    @Column
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private int area;

    @Column
    private String street;

    @Column
    private String number;

    @Column
    private String City;

    @Column
    private String postalCode;

    @Column
    @Enumerated(EnumType.STRING)
    private ProductsRange  accesories;

    @Column
    @Enumerated(EnumType.STRING)
    private ProductsRange  drinks;

    @Column
    @Enumerated(EnumType.STRING)
    private ProductsRange  foods;

    @Column
    @Enumerated(EnumType.STRING)
    private ProductsRange  bigHouseHoldGoods;

    @Column
    @Enumerated(EnumType.STRING)
    private ProductsRange  smallHouseHoldGoods;

    @Column
    @Enumerated(EnumType.STRING)
    private ProductsRange  rtv;

    @Column
    @Enumerated(EnumType.STRING)
    private ProductsRange  smallElectronics;

    @Column
    @Enumerated(EnumType.STRING)
    private ProductsRange  computers;


}
