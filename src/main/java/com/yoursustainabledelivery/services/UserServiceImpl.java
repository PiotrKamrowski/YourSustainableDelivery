package com.yoursustainabledelivery.services;


import com.yoursustainabledelivery.dao.UserDao;
import com.yoursustainabledelivery.model.Permission;
import com.yoursustainabledelivery.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;


    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateStoreUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUserById(String login) {

       return userDao.getUser(login);
    }

    @Override
    public List<User> getUsersStoresList() {

        String query = "FROM User u WHERE u.permission = :FULL or u.permission = :USER";



        return userDao.getUsersListTwoParams(query, Permission.FULL, Permission.USER);
    }


}
