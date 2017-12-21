package com.yoursustainabledelivery.services;


import com.yoursustainabledelivery.dao.ProductDao;
import com.yoursustainabledelivery.model.Category;
import com.yoursustainabledelivery.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.text.normalizer.UCharacter;

import java.math.BigDecimal;
import java.util.List;

@Service(value = "productService")
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDao productDao;


    @Override
<<<<<<< HEAD
    public List<Object> getListOfProducts() {

        return productDao.getList();
    }
=======
    public void addProduct(long ean,String name,double purchasep,String category,int inbox) {


        Product product = new Product();




        product.setName(name);
        product.setEan(ean);
        product.setPurchasePrice(purchasep);
        product.setCategory(Category.valueOf(category));
        product.setInBox(inbox);


        productDao.addProduct(product);
    }


>>>>>>> 215e3ea6ead369c56500e0d4df1a47bd198bc980
}
