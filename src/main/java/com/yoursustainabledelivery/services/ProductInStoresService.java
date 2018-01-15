package com.yoursustainabledelivery.services;

import com.yoursustainabledelivery.model.ProductInStore;

import java.util.List;

public interface ProductInStoresService {

    List<Object> getListOfProductsInStores();

    void addProductToStore(ProductInStore productInStore);

    List<Object> getListOfProductsInStoreParam(Long id);



    boolean isProductinStore(Long storeId,Long productId);

}
