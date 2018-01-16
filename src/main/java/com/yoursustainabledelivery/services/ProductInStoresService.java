package com.yoursustainabledelivery.services;

import com.yoursustainabledelivery.model.ProductInStore;

import java.util.List;

public interface ProductInStoresService {



    void addProductToStore(ProductInStore productInStore);

    List<Object> getListOfProductsInStore(Long id);



    boolean isProductinStore(Long storeId,Long productId);

}
