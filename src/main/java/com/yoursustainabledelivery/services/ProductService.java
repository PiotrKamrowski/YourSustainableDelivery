package com.yoursustainabledelivery.services;

import com.yoursustainabledelivery.model.Category;
import com.yoursustainabledelivery.model.Product;

import java.util.List;

public interface ProductService {

List<Object> getListOfProducts();

void addProduct(long ean,String name,double purchasep,String category,int inbox);

Object getProduct (Long id);


List<Product> getListProductsCategory(String category);

List<Product> getListProductsByRange (int range, String category);

}
