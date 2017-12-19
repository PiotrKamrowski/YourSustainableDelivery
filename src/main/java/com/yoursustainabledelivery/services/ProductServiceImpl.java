package com.yoursustainabledelivery.services;


import com.yoursustainabledelivery.dao.ProductDao;
import com.yoursustainabledelivery.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "ProductService")
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDao productDao;


    @Override
    public Boolean productToAdd(Product productToAdd) {
        return null;
    }
}
