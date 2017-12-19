package com.yoursustainabledelivery.controllers;


import com.yoursustainabledelivery.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> requestTest()
    { return new ResponseEntity<String>(
            "REST API DZIAŁA!", HttpStatus.OK); }







}
