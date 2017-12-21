package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.ProductInStore;
import org.springframework.stereotype.Repository;

@Repository(value = "productInStoresDao")
public class ProductInStoresDaoImpl extends AbstractDao implements ProductInStoresDao{




    @Override
    public void addProductInStore(ProductInStore productInStore) {
        persist(productInStore);
    }
}
