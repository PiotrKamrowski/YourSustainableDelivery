package com.yoursustainabledelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Product")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {




    @Id
    private long ean;

    private String name;

    private double purchasePrice;

    @Enumerated(EnumType.STRING)
    private Category category;

    private int inBox;









}
