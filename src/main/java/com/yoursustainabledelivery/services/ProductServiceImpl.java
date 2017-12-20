package com.yoursustainabledelivery.services;


import com.yoursustainabledelivery.dao.ProductDao;
import com.yoursustainabledelivery.model.Category;
import com.yoursustainabledelivery.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.text.normalizer.UCharacter;

import java.math.BigDecimal;

@Service(value = "productService")
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDao productDao;









}
