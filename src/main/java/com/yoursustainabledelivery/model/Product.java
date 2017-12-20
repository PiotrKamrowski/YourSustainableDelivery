package com.yoursustainabledelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;



import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {




    @Id
    private long ean;

    private String name;

    @Column(name = "purchasep")
    private double purchasePrice;

    @Enumerated(EnumType.STRING)
    private Category category;

    private int inBox;









}
