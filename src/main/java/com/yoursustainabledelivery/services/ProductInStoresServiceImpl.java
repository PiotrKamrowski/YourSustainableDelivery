package com.yoursustainabledelivery.services;

import com.yoursustainabledelivery.dao.ProductDao;
import com.yoursustainabledelivery.dao.ProductInStoresDao;
import com.yoursustainabledelivery.model.Product;
import com.yoursustainabledelivery.model.ProductInStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(value = "productInStoresService")
@Transactional
public class ProductInStoresServiceImpl implements ProductInStoresService {


    @Autowired
    ProductInStoresDao productInStoresDao;

    @Autowired
    ProductDao productDao;




    @Override
    public void addProductToStore(ProductInStore productInStore) {

        productInStoresDao.addProductInStore(productInStore);

    }

    @Override
    public List<Object> getListOfProductsInStore(Long id) {

        String query ="FROM ProductInStore p WHERE p.id_store =:id";

        return productInStoresDao.getProductsInStoreParam(query,id,"id");
    }

    @Override
    public boolean isProductinStore(Long storeId, Long productId) {



        List list = getListOfProductsInStore(storeId);
        Product object = (Product)productDao.getProduct(productId);

        List<ProductInStore> productList =(List<ProductInStore>)list;

        Long id = object.getEan();

        for(int i = 0;i<productList.size();i++){

            if(productList.get(i).getId_item() == id){
                return true;
            }


        }



        return false;


    }
}
