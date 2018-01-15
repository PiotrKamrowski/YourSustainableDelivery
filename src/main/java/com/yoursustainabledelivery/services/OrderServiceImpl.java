package com.yoursustainabledelivery.services;


import com.yoursustainabledelivery.dao.OrderDao;
import com.yoursustainabledelivery.model.Order;
import com.yoursustainabledelivery.model.ProductInStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "orderService")
@Transactional
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderDao orderDao;


    @Override
    public void addOrder(Order order) {

        orderDao.addOrder(order);
    }

    @Override
    public List<Order> getListOrdersByStore(Long idStore) {

        List list = orderDao.getOrderList(idStore);

        List<Order> listOrder = (List<Order>)list;

        return listOrder;

    }

    @Override
    public int inOrderCorrecting(ProductInStore productInStore, Long StoreId) {

       List list = orderDao.getOrderList(StoreId,productInStore.getId_item());

       List<Order> listOrder = (List<Order>)list;

       int result = 0;

       if(listOrder.isEmpty()){

        return 0;

    }else{
           for(int i = 0;i<listOrder.size();i++){

               result = result+listOrder.get(i).getQuanity();

           }
       }

       return result;
}}
