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
    public Object getProductInStore(Long storeId, Long itemId) {

        String query = "FROM ProductInStore p WHERE p.id_store=:id_Store and p.id_item=:id_Item";


        return getObjectQTwoParam(query,storeId,itemId,"id_Store","id_Item");
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
