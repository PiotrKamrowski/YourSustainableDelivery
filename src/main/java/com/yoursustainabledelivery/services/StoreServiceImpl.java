package com.yoursustainabledelivery.services;

import com.yoursustainabledelivery.dao.StoreDao;
import com.yoursustainabledelivery.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "storeService")
@Transactional
public class StoreServiceImpl implements StoreService{



    @Autowired
    StoreDao storeDao;


    @Override
    public Store getStore(Long id) {
        return storeDao.getStore(id);
    }

    @Override
    public void updateStore(Store store) {

        storeDao.update(store);
    }
}
