package com.yoursustainabledelivery.dao;

import com.yoursustainabledelivery.model.Order;

import java.util.List;

public interface OrderDao {


    void addOrder(Order order);

    List<Object> getOrderList(Long storeId, Long ProductInStorId);

    List<Object> getOrderList(Long storeId);




}
