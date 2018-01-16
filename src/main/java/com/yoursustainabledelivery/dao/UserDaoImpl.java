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

        Object object = getObject(User.class,login);

        return (User)object;
    }

    @Override
    public List<User> getUsersListTwoParams(String query, Object paramOne, Object paramTwo) {



        List list = getListOfObjectsQtwoParams(query,paramOne,paramTwo);

        return (List<User>)list;
    }

    @Override
    public void update(Object object) {
        update(object);
    }
}
