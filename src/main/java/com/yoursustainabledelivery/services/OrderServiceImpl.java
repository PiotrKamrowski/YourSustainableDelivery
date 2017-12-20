package com.yoursustainabledelivery.services;


import com.yoursustainabledelivery.dao.OrderDao;
import com.yoursustainabledelivery.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "orderService")
@Transactional
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderDao orderDao;



}
