package com.yoursustainabledelivery.dao;


import com.yoursustainabledelivery.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "OrderDao")
public class OrderDaoImpl extends AbstractDao implements OrderDao{


    @Override
    public void addOrder(Order order) {

        persist(order);

    }

    @Override
    public List<Object> getOrderList(Long storeId, Long ProductInStorId) {

       return getListofObjectsOrder(storeId,ProductInStorId);

    }

    @Override
    public List<Object> getOrderList(Long storeId) {

        return getListofObjectsOrderOneParam(storeId);
    }
}

