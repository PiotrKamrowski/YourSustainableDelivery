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
    public ResponseEntity<List<ProductInStore>> productsInStoreList(@PathVariable("storeId") Long id){

        List<ProductInStore> list = productInStoresService.getListOfProductsInStore(id);

        return new ResponseEntity<List<ProductInStore>>(list, HttpStatus.OK);
    }


    @RequestMapping(value = "/product/{storeId}/{itemId}",method = RequestMethod.GET)
    public ResponseEntity<ProductInStore> productInStore(@PathVariable("storeId") Long id, @PathVariable("itemId") Long itemId){

        ProductInStore productInStore = productInStoresService.getProductInStoreQuery(id,itemId);

        return new ResponseEntity<ProductInStore>(productInStore, HttpStatus.OK);
    }




    @RequestMapping(value = "/isInStore/{storeId}/{productId}",method = RequestMethod.GET)
    public ResponseEntity<Boolean> isInStore(@PathVariable("storeId") Long storeId, @PathVariable("productId") Long productId){

        Boolean answer = productInStoresService.isProductinStore(storeId,productId);




        return new ResponseEntity<Boolean>(answer, HttpStatus.OK);
    }






}
