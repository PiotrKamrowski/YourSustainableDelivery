package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao {


    void addUser(User user);

    User getUser(String Login);

    List<User> getUsersList();


    void update(Object object);
}
