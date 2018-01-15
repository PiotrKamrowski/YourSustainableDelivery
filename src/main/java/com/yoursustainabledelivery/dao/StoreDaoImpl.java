package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.Store;
import org.springframework.stereotype.Repository;

@Repository(value = "StoreDao")
public class StoreDaoImpl extends AbstractDao implements StoreDao{


    @Override
    public Store getObject(Long id) {
        Object object = getObject(Store.class,id);
        Store store = (Store)object;
        return store;
    }
}
