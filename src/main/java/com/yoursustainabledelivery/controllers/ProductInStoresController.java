package com.yoursustainabledelivery.controllers;

import com.yoursustainabledelivery.services.ProductInStoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductInStoresController {


    @Autowired
    private ProductInStoresService productInStoresService;

    @RequestMapping(value = "/productInStore/{storeId}",method = RequestMethod.GET)
    public ResponseEntity<List<Object>> productInStore(@PathVariable("storeId") Long id){

        List<Object> list = productInStoresService.getListOfProductsInStoreParam(id);

        return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
    }





}
