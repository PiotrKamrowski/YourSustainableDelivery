package com.yoursustainabledelivery.controllers;

import com.yoursustainabledelivery.model.ProductInStore;
import com.yoursustainabledelivery.services.ProductInStoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController(value = "/productsinstores/")
@RequestMapping(value = "/productsInStores/")
public class ProductInStoresController {


    @Autowired
    private ProductInStoresService productInStoresService;

    @RequestMapping(value = "/productInStore/{storeId}",method = RequestMethod.GET)
    public ResponseEntity<List<Object>> productInStore(@PathVariable("storeId") Long id){

        List<Object> list = productInStoresService.getListOfProductsInStoreParam(id);

        return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
    }



    @RequestMapping(value = "/isInStore/{storeId}/{productId}",method = RequestMethod.GET)
    public ResponseEntity<Boolean> isInStore(@PathVariable("storeId") Long storeId, @PathVariable("productId") Long productId){

        Boolean answer = productInStoresService.isProductinStore(storeId,productId);




        return new ResponseEntity<Boolean>(answer, HttpStatus.OK);
    }



    @RequestMapping(value = "/addProduct2", method = RequestMethod.GET)
    public ResponseEntity<String> registerUser(){


        ProductInStore productInStore = new ProductInStore();

        productInStore.setPrice(22);
        productInStore.setId_store(1l);
        productInStore.setMinSupply(1);
        productInStore.setPrice(222);
        productInStore.setId_item(3454323456043l);

        productInStoresService.addProductToStore(productInStore);



        return new ResponseEntity<String>( "OK", HttpStatus.OK); }


}
