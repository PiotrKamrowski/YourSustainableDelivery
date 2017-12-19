package com.yoursustainabledelivery.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ProductsInstores")
public class ProductInStore {

    private long id_store;

    private long id_item;

    private int quanity;

    private int minSupply;

    private double price;

    private boolean block;

}


