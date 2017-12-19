package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.Product;

public interface ProductDao {

    void addProduct(Product p);

    void addListOfProducts(long storeId);




}
