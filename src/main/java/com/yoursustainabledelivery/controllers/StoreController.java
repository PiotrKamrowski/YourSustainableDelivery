package com.yoursustainabledelivery.controllers;


import com.yoursustainabledelivery.model.SmallUser;
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


    @RequestMapping(value = "/yourStore/{StoreId}", method = RequestMethod.GET)
    public ResponseEntity<Store> getStore(@PathVariable("StoreId") Long id) {

        Store store = storeService.getStore(id);

        return new ResponseEntity<Store>(store, HttpStatus.OK);

    }

    @RequestMapping(value = "/editRange/{StoreId}", method = RequestMethod.POST)
    public ResponseEntity<String[]> checkUser(@RequestBody String[] edited, @PathVariable("StoreId") Long storeID) {


        Store store = storeService.getStore(storeID);

        store.setAccesories(Integer.valueOf(edited[0]));
        store.setDrinks(Integer.valueOf(edited[1]));
        store.setFoods(Integer.valueOf(edited[2]));
        store.setBigHouseHoldGoods(Integer.valueOf(edited[3]));
        store.setSmallHouseHoldGoods(Integer.valueOf(edited[4]));
        store.setRtv(Integer.valueOf(edited[5]));
        store.setSmallElectronics(Integer.valueOf(edited[6]));
        store.setComputers(Integer.valueOf(edited[7]));

        storeService.updateStore(store);


        return new ResponseEntity<String[]>(edited, HttpStatus.OK);
    }


}
