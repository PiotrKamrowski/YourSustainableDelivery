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

    public List<Object> getList() {
        return getListofObjects(Product.class);
    }

    @Override
    public Object getProduct(Long id) {



        return getObject(Product.class,id);
    }


    public void addProduct(Product product) {
        persist(product);
    }

    @Override
    public List<Object> getProductListByCategory(String category) {


       return  getListOfProductsByCategory(category);


    }
}
