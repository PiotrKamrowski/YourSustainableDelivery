package com.yoursustainabledelivery.services;

import com.yoursustainabledelivery.model.Order;
import com.yoursustainabledelivery.model.ProductInStore;

import java.util.List;

public interface OrderService {

void addOrder(Order order);


List<Order> getListOrdersByStore(Long idStore);






int inOrderCorrecting(ProductInStore productInStore,Long StoreId);

}
