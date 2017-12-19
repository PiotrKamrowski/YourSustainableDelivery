package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.Product;
import org.springframework.stereotype.Repository;

@Repository(value = "ProductDao")
public class ProductDaoImpl extends AbstractDao implements ProductDao  {



    @Override
    public void addProduct(Product product) {

        persist(product);


    }


}
