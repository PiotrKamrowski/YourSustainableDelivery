package com.yoursustainabledelivery.controllers;


import com.yoursustainabledelivery.model.Order;
import com.yoursustainabledelivery.model.Product;
import com.yoursustainabledelivery.services.OrderService;
import com.yoursustainabledelivery.services.OrderServiceImpl;
import com.yoursustainabledelivery.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController(value = "/orders/")
@RequestMapping(value = "orders")
public class OrderController {

@Autowired
    OrderService orderService;
@Autowired
    ProductService productService;

    @RequestMapping(value = "/ordersList/{storeId}",method = RequestMethod.GET)
    public ResponseEntity<List<Order>> OrdersListByStore(@PathVariable("storeId") Long storeID){

        List<Order> answer = orderService.getListOrdersByStore(storeID);

        return new ResponseEntity<List<Order>>(answer, HttpStatus.OK);
    }

    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public ResponseEntity<Order> addOrder(@RequestBody Order order){

        Product product = (Product)productService.getProduct(order.getId_item());
        int quanityOrder = order.getQuanity();
        int inBox = product.getInBox();
        while(quanityOrder%inBox != 0){
            quanityOrder++;
        }

        order.setQuanity(quanityOrder);
        orderService.addOrder(order);

        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }








}
