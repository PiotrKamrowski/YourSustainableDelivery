package com.yoursustainabledelivery.controllers;


import com.yoursustainabledelivery.model.Store;
import com.yoursustainabledelivery.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController(value = "/store/")
@RequestMapping(value = "store")
public class StoreController {



    @Autowired
    StoreService storeService;



    @RequestMapping(value = "/yourStore/{StoreId}",method = RequestMethod.GET)
    public ResponseEntity<Store> getStore(@PathVariable("StoreId") Long id) {

        Store store = storeService.getStore(id);

        return new ResponseEntity<Store>(store, HttpStatus.OK);

    }



}
