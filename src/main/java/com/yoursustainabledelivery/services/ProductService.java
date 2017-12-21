package com.yoursustainabledelivery.services;

import com.yoursustainabledelivery.model.Product;

import java.util.List;

public interface ProductService {

List<Object> getListOfProducts();

void addProduct(long ean,String name,double purchasep,String category,int inbox);



}
