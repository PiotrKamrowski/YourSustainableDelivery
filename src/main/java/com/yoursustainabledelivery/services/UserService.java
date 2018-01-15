package com.yoursustainabledelivery.services;

import com.yoursustainabledelivery.model.User;

import java.util.List;

public interface UserService {



    void addUser(User user);

    void updateUser(User user);

    User getUserById(String login);

        List<User> getUsersStoresList();

}

