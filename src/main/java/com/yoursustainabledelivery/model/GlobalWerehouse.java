package com.yoursustainabledelivery.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "GlobalWerehouse")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalWerehouse {

    @Id
    private long id_item;

    private int quanity;


}
