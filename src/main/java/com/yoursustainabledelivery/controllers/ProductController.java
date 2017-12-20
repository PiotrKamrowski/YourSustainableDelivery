package com.yoursustainabledelivery.controllers;


import com.yoursustainabledelivery.dao.GlobalWerehouseDao;
import com.yoursustainabledelivery.dao.ProductInStoresDao;
import com.yoursustainabledelivery.model.Category;
import com.yoursustainabledelivery.model.GlobalWerehouse;
import com.yoursustainabledelivery.model.Product;
import com.yoursustainabledelivery.model.ProductInStore;
import com.yoursustainabledelivery.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> requestTest()
    {


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





}
