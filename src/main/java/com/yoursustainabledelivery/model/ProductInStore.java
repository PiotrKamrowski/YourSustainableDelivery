package com.yoursustainabledelivery.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ProductsInstores")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductInStore implements Serializable {


    @Id
    private long id_store;
    @Id
    private long id_item;

    private int quanity;

    private int minSupply;

    private int inOrders;

    private double price;

    private boolean block;




    @OneToOne
    @JoinColumn(name = "id_item", updatable = false, insertable = false,referencedColumnName = "ean")
    private Product productDetail;



    }



