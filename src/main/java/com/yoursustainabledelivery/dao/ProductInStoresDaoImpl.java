package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.Product;
import com.yoursustainabledelivery.model.ProductInStore;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "productInStoresDao")
public class ProductInStoresDaoImpl extends AbstractDao implements ProductInStoresDao{



    @Override
    public List<Object> getList() {
        return getListofObjects(ProductInStore.class);
    }

    @Override
    public List<Object> getProductsInStoreParam(String query, Object param, String ident) {
        return getListOfObjectsQoneParam(query,param,ident);
    }




    @Override
    public void addProductInStore(ProductInStore productInStore) {
        persist(productInStore);
    }
}
