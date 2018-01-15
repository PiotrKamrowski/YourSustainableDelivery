package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {
    @Override
    public void addUser(User user) {

        persist(user);
    }

    @Override
    public User getUser(String login) {

        Object object = getObjectByIdString(User.class,login);

        return (User)object;
    }

    @Override
    public List<User> getUsersList() {
        List list = getListOfUsers();

        return (List<User>)list;
    }

    @Override
    public void update(Object object) {
        updateObject(object);
    }
}
