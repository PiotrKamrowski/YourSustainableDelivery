package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.ProductInStore;

import java.util.List;

public interface ProductInStoresDao {


    void addProductInStore(ProductInStore productInStore);

    List<Object> getList();

    Object getProductInStore(Long storeId,Long itemId);

    List<Object> getProductsInStoreParam(String query, Object param, String ident);

}

