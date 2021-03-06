package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.Category;
import com.yoursustainabledelivery.model.Product;

import java.util.List;

public interface ProductDao {


List<Object> getList();


List<Object> getListOfProductsByRange(int rage,String Category);


Object getProduct(Long id);


void addProduct(Product product);

List<Object> getProductListByCategory(String query, Object param);



}
