package com.yoursustainabledelivery.model;

import javax.persistence.*;

@Entity
@Table(name = "GlobalStores")
public class Product {


    @Id
    @Column
    @GeneratedValue
    private long id;

    @Column
    private long ean;

    @Column
    private String name;

    @Column
    private int purchasePrice;

    @Column
    private int minSupply;

    @Column
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column
    private int quanity;

    @Column
    private int inOrders;

    @Column
    private int inBox;

    @Column
    private boolean block;









}
