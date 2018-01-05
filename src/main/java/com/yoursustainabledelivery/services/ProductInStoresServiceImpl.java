package com.yoursustainabledelivery.services;

import com.yoursustainabledelivery.dao.ProductInStoresDao;
import com.yoursustainabledelivery.model.ProductInStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(value = "productInStoresService")
@Transactional
public class ProductInStoresServiceImpl implements ProductInStoresService {


    @Autowired
    ProductInStoresDao productInStoresDao;


    @Override
    public List<Object> getListOfProductsInStores() {
        return productInStoresDao.getList();
    }

    @Override
    public void addProductToStore(ProductInStore productInStore) {

        productInStoresDao.addProductInStore(productInStore);

    }

    @Override
    public List<Object> getListOfProductsInStoreParam(Long id) {
        return productInStoresDao.getProductsInStoreParam(id);
    }
}
