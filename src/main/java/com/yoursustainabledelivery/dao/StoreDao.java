package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.Store;

public interface StoreDao {



    Store getStore(Long id);

    void update(Store store);


}
