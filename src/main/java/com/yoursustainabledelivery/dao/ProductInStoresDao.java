package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.ProductInStore;

import java.util.List;

public interface ProductInStoresDao {


    void addProductInStore(ProductInStore productInStore);

    List<Object> getList();

    List<Object> getProductsInStoreParam(Long id);

}

