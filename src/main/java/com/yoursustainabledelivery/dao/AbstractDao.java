package com.yoursustainabledelivery.dao;

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

    public Object getObject(Class className, long id) {
        return getSession().load(className, id);
    }


    public List<Object> getListofObjects(Class classa)
    { return getSession().createCriteria(classa).list(); }


    public List<Object> getListofObjectsParam(Long id){

       Query query = getSession().createQuery("SELECT p FROM  ProductInStore p WHERE p.id_store =:id ");
        query.setParameter("id",id);

        return query.list();
    }



}



