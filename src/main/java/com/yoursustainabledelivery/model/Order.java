package com.yoursustainabledelivery.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;
@Data
@Entity
@Table(name = "orders")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private long id_store;

    private long id_item;

    private int quanity;

    private boolean delivered;

    @Column(name = "date_create",insertable = false,updatable = false)
    private Date date;


}