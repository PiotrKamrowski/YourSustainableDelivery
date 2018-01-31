package com.yoursustainabledelivery.services;

import com.yoursustainabledelivery.model.ProductInStore;

import java.util.List;

public interface ProductInStoresService {



    void addProductToStore(ProductInStore productInStore);

    List<ProductInStore> getListOfProductsInStore(Long id);

    ProductInStore getProductInStoreQuery(Long storeId, Long itemID);


    boolean isProductinStore(Long storeId,Long productId);

    void updateProductInStore(ProductInStore productInStore);
}
