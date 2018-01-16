package com.yoursustainabledelivery.model;

import lombok.Data;

import javax.persistence.Transient;

@Data
public class SmallUser {

    private String login;

    private String password;

    private Long storeId;

    private Permission permission;

    @Transient
    private boolean correctlogin;
}
