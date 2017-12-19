package com.yoursustainabledelivery.services;


import com.yoursustainabledelivery.dao.ProductDao;
import com.yoursustainabledelivery.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "productService")
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDao productDao;






    @Override
    public void addProductList() {

        productDao.addListOfProducts(1l);
    }

    @Override
    public void productToAdd(long productId, long storeId, int count) {

    }
}
