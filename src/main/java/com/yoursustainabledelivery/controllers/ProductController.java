package com.yoursustainabledelivery.controllers;


import com.yoursustainabledelivery.dao.GlobalWerehouseDao;
import com.yoursustainabledelivery.dao.ProductInStoresDao;
import com.yoursustainabledelivery.model.*;
import com.yoursustainabledelivery.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController(value = "/products/")
@RequestMapping(value = "products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductInStoresService productInStoresService;



    @RequestMapping(value = "/productsList",method = RequestMethod.GET)
    public ResponseEntity<List<Object>> productList(){

       List<Object> list = productService.getListOfProducts();

       return new ResponseEntity<List<Object>>(list,HttpStatus.OK);
    }



    @RequestMapping(value = "/productsList/{itemId}",method = RequestMethod.GET)
    public ResponseEntity<Object> productInStore(@PathVariable("itemId") Long id) {

       Object product = productService.getProduct(id);

        return new ResponseEntity<Object>(product, HttpStatus.OK);

    }



    @RequestMapping(value = "/list/{category}",method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getListProductParams(@PathVariable("category") String category) {

        List<Product> answer = productService.getListProductsCategory(category);

        return new ResponseEntity<List<Product>>(answer, HttpStatus.OK);



    }





    @RequestMapping(value = "/addProductInStore",method = RequestMethod.POST)
    public ResponseEntity<ProductInStore> addProductInStore(@RequestBody ProductInStore productInStore){



    int inOrderByOrder = orderService.inOrderCorrecting(productInStore,productInStore.getId_store());



    productInStore.setInOrders(inOrderByOrder);

        System.out.println(productInStore);


         productInStoresService.addProductToStore(productInStore);

        return new ResponseEntity<ProductInStore>(productInStore, HttpStatus.OK);
    }





    @RequestMapping(value = "/testadd23", method = RequestMethod.GET)
    public ResponseEntity<String> requestTestadd2()
    {
        Order order = new Order();

        order.setId_store(1);
        order.setId_item(4375678765432l);
        order.setQuanity(10);



        orderService.addOrder(order);


        return new ResponseEntity<String>(
                "REST API DZIAŁA!", HttpStatus.OK); }







    @RequestMapping(value = "/testadd", method = RequestMethod.GET)
    public ResponseEntity<String> requestTestadd()
    {



        return new ResponseEntity<String>(
            "REST API DZIAŁA!", HttpStatus.OK); }


    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public ResponseEntity<String> registerUser(@RequestParam long ean, @RequestParam String name,@RequestParam double purchasePrise,@RequestParam String category,@RequestParam int inbox){



       productService.addProduct(ean,name,purchasePrise,category,inbox);


        return new ResponseEntity<String>( "OK", HttpStatus.OK); }


        @RequestMapping(value = "/RTV",method = RequestMethod.GET)
        public ResponseEntity<List<Product>> getListProductsRTV(){


        List<Product> answer = productService.getListProductsCategory("RTV");


        return new ResponseEntity<List<Product>>(answer,HttpStatus.OK);
        }



}
