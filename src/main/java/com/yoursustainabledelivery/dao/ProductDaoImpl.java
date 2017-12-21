package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.Category;
import com.yoursustainabledelivery.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

@Repository(value = "productDao")
public class ProductDaoImpl extends AbstractDao implements ProductDao {


    @Override
<<<<<<< HEAD
    public List<Object> getList() {
        return getListofObjects(Product.class);
    }
}
=======
    public void addProduct(Product product) {
        persist(product);
    }
}
>>>>>>> 215e3ea6ead369c56500e0d4df1a47bd198bc980
