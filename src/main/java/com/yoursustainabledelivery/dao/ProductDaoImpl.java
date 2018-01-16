package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "productDao")
public class ProductDaoImpl extends AbstractDao implements ProductDao {


    @Override

    public List<Object> getList() {
        return getListofObjects(Product.class);
    }

    @Override
    public Object getProduct(Long id) {



        return getObject(Product.class,id);
    }


    public void addProduct(Product product) {
        persist(product);
    }

    @Override
    public List<Object> getProductListByCategory(String query ,Object param) {


       return  getListOfObjectsQoneParam(query, param);


    }
}
