package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.Category;
import com.yoursustainabledelivery.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "productDao")
public class ProductDaoImpl extends AbstractDao implements ProductDao {


    @Override

    public List<Object> getList() {
        return getListofObjects(Product.class);
    }

    @Override
    public List<Object> getListOfProductsByRange(int rage,String category) {

        String query = "From Product p where p.range =:range and p.category =:category";

        return getListofObjectsQtwoParams(query,rage,Category.valueOf(category),"range","category");


    }

    @Override
    public Object getProduct(Long id) {



        return getObject(Product.class,id);
    }


    public void addProduct(Product product) {
        persist(product);
    }

    @Override
    public List<Object> getProductListByCategory(String query ,Object param) {


        String ident = "category";

       return  getListOfObjectsQoneParam(query, param,ident);


    }
}
