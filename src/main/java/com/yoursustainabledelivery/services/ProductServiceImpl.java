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
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;


    @Override
    public List<Object> getListOfProducts() {

        return productDao.getList();
    }

    public void addProduct(long ean, String name, double purchasep, String category, int inbox) {


        Product product = new Product();


        product.setName(name);
        product.setEan(ean);
        product.setPurchasePrice(purchasep);
        product.setCategory(Category.valueOf(category));
        product.setInBox(inbox);


        productDao.addProduct(product);
    }

    @Override
    public Object getProduct(Long id) {

        productDao.getProduct(id);


        return productDao.getProduct(id);


    }

    @Override
    public List<Product> getListProductsCategory(String category) {

        String query = "FROM Product p WHERE p.category =:category";

        Category cat = Category.valueOf(category);

        List list = productDao.getProductListByCategory(query,cat);

        List<Product> listProduct = (List<Product>)list;

        return listProduct;

    }
}
