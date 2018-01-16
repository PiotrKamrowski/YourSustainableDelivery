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
    public List<Object> getOrderListByProduct(Long storeId, Long productInStoreID) {

        String query = "FROM Order o WHERE o.id_item =:idItem and o.id_store =:idStore and o.delivered = false ";


       return getListofObjectsQtwoParams(query,storeId,productInStoreID,"idStore","idItem");

    }

    @Override
    public List<Object> getOrderList(Long storeId) {

        String query = "FROM Order o WHERE   o.id_store =:idStore";


        return getListOfObjectsQoneParam(query,storeId,"idStore");
    }
}

