package com.yoursustainabledelivery.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "appusers")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @Id
    @Column(name = "id")
    private String login;

    private Long idStore;


    @Column(name = "permissions")
    @Enumerated(EnumType.STRING)
    private Permission permission;


    private String userPassword;

    private String userName;

    private String userSurname;

    private int phone;

    private String email;

    private Long personnumber;






}
