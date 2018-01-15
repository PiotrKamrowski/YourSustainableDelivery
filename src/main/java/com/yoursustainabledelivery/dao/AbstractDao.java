package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.Category;
import com.yoursustainabledelivery.model.Permission;
import com.yoursustainabledelivery.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void persist(Object entity) {
        getSession().persist(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }


    // problem z metoda get

    public Object getObject(Class className, long id) {

        Object object = new Object();
/*
        Query query = getSession().createQuery("FROM Product p WHERE p.ean=:id");

        query.setParameter("id",id);

        object = query.uniqueResult();*/

        object = getSession().get(className, id);

        return object;
    }


    public Object getObjectByIdString(Class className, String id){

        Object object = getSession().get(className,id);

        return object;
    }


    public List<Object> getListOfProductsByCategory(String category) {

        Query query = getSession().createQuery("FROM Product p WHERE p.category =:category");
        query.setParameter("category", Category.valueOf(category));

        return query.list();

    }

    public List<Object> getListOfUsers() {

        Query query = getSession().createQuery("FROM User u WHERE u.permission = :p1 or u.permission = :p2");
        query.setParameter("p1", Permission.FULL);
        query.setParameter("p2", Permission.USER);
        return query.list();
    }

    public List<Object> getListofObjects(Class classa) {
        return getSession().createCriteria(classa).list();
    }


    public List<Object> getListofObjectsParam(Long id) {

        Query query = getSession().createQuery("FROM ProductInStore p WHERE p.id_store =:id ");
        query.setParameter("id", id);

        return query.list();
    }

    public List<Object> getListofObjectsOrder(Long idStore, Long idIteam) {

        Query query = getSession().createQuery("FROM Order o WHERE o.id_item =:idItem and o.id_store =:idStore and o.delivered = false ");
        query.setParameter("idItem", idIteam);
        query.setParameter("idStore", idStore);

        return query.list();
    }

    public List<Object> getListofObjectsOrderOneParam(Long idStore) {

        Query query = getSession().createQuery("FROM Order o WHERE   o.id_store =:idStore");
        query.setParameter("idStore", idStore);

        return query.list();
    }


    public void updateObject(Object object){

        getSession().update(object);
    }



}






