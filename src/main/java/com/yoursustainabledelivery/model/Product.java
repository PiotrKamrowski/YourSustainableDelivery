package com.yoursustainabledelivery.model;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "globalproductlist")
public class Product {


    private long id_store;

    @Id
    @GeneratedValue
    private long id_item;



    private long ean;


    private String name;


    private double purchasePrice;


    private int minSupply;


    @Enumerated(EnumType.STRING)
    private Category category;


    private int quanity;


    private int inOrders;


    private int inBox;


    private boolean block;









}
