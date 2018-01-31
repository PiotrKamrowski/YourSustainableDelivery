package com.yoursustainabledelivery.controllers;


import com.yoursustainabledelivery.model.Product;
import com.yoursustainabledelivery.model.ProductInStore;
import com.yoursustainabledelivery.model.SmallUser;
import com.yoursustainabledelivery.model.Store;
import com.yoursustainabledelivery.services.ProductInStoresService;
import com.yoursustainabledelivery.services.ProductService;
import com.yoursustainabledelivery.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController(value = "/store/")
@RequestMapping(value = "store")
public class StoreController {


    @Autowired
    StoreService storeService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductInStoresService productInStoresService;


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

        String[] bufferRangeArray = edited;
        String[] bufforCategoryArray = { "ACCESORIES","DRINKS","FOODS","BIGHOUSEHOLDGOODS","SMALLHOUSEHOLDGOODS","RTV","SMALLELECTRONICS","COMPUTERS"};

        List<ProductInStore> productInStore = productInStoresService.getListOfProductsInStore(storeID);


        for(int i = 0; i<edited.length;i++){


            List<Product> bufforProductList = productService.getListProductsByRange(Integer.valueOf(bufferRangeArray[i]),bufforCategoryArray[i]);



            for(int v = 0; v<bufforProductList.size();v++){

                Product bufforProduct = bufforProductList.get(v);

                ProductInStore productInStoreNew = new ProductInStore();

                productInStoreNew.setId_item(bufforProduct.getEan());
                productInStoreNew.setId_store(storeID);
                productInStoreNew.setQuanity(0);
                productInStoreNew.setMinSupply(bufforProduct.getInBox());
                productInStoreNew.setInOrders(0);
                productInStoreNew.setPrice(1.2*(bufforProduct.getPurchasePrice()));
                productInStoreNew.setBlock(false);
                productInStoreNew.setProductDetail(bufforProduct);

                if(productInStoresService.isProductinStore(storeID,productInStoreNew.getId_item())){

                   ProductInStore originalProductInStore = productInStoresService.getProductInStoreQuery(storeID,productInStoreNew.getId_item());

                   originalProductInStore.setBlock(false);
                   originalProductInStore.setMinSupply(productInStoreNew.getMinSupply());

                   productInStoresService.updateProductInStore(originalProductInStore);
                }else{

                    productInStoresService.addProductToStore(productInStoreNew);
                }


            }



        }









        return new ResponseEntity<String[]>(edited, HttpStatus.OK);
    }


}
