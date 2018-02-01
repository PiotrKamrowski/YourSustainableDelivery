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

    public void updateObject(Object entity) { getSession().update(entity);}


    public Object getObjectQTwoParam(String query, Object paramOne, Object paramTwo, String identOne, String identTwo){

        Query q = getSession().createQuery(query);
        q.setParameter(identOne, paramOne);
        q.setParameter(identTwo, paramTwo);
        return q.uniqueResult();

    }

    public Object getObject(Class className, long id) {

        Object object = new Object();
        object = getSession().get(className, id);

        return object;
    }


    public Object getObject(Class className, String id){

        Object object = getSession().get(className,id);

        return object;
    }





    public List<Object> getListOfObjectsQtwoParams(String query, Object  paramOne, Object paramTwo) {

        Query q = getSession().createQuery(query);
        q.setParameter(String.valueOf(paramOne), paramOne);
        q.setParameter(String.valueOf(paramTwo), paramTwo);
        return q.list();


    }

    public List<Object> getListofObjectsQtwoParams(String query, Object  paramOne, Object paramTwo, String identOne, String identTwo) {



        Query q = getSession().createQuery(query);
        q.setParameter(identOne, paramOne);
        q.setParameter(identTwo, paramTwo);
        return q.list();
    }

    public List<Object> getListofObjectsQthreeParams(String query, Object paramOne, Object paramTwo, Object paramThree, String identOne,String identTwo,String identThree){

        Query q = getSession().createQuery(query);
        q.setParameter(identOne,paramOne);
        q.setParameter(identTwo,paramTwo);
        q.setParameter(identThree,paramThree);

        return  q.list();


    }


    public List<Object> getListofObjects(Class classa) {
        return getSession().createCriteria(classa).list();
    }


    public List<Object> getListOfObjectsQoneParam(String query, Object param, String ident) {

        Query q = getSession().createQuery(query);
        q.setParameter(ident, param);

        return q.list();
    }


    void updateObjectQthreeParam(String query, Object paramOne, Object paramTwo, Object paramThree, String identOne,String identTwo,String identThree){

        Query q = getSession().createQuery(query);
        q.setParameter(identOne,paramOne);
        q.setParameter(identTwo,paramTwo);
        q.setParameter(identThree,paramThree);
        q.executeUpdate();

    }






}






