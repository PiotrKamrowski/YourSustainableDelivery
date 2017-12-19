package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.Category;
import com.yoursustainabledelivery.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

@Repository(value = "ProductDao")
public class ProductDaoImpl extends AbstractDao implements ProductDao  {



    @Override
    public void addProduct(Product product) {

        persist(product);


    }

    @Override
    public void addListOfProducts(long storeId) {

       

    }


}
