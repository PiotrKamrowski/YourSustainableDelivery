package com.yoursustainabledelivery.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "GlobalWerehouse")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalWerehouse {

    private long id_item;
    private int quanity;


}
