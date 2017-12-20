package com.yoursustainabledelivery.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ProductsInstores")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductInStore {

    @Id
    private long id_store;

    private long id_item;

    private int quanity;

    private int minSupply;

    private int inOrders;

    private double price;

    private boolean block;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_item", referencedColumnName = "ean", insertable = false, updatable = false)
    private Product productDetail;

}


