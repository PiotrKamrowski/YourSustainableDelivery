package com.yoursustainabledelivery.controllers;


import com.yoursustainabledelivery.model.*;
import com.yoursustainabledelivery.services.OrderService;
import com.yoursustainabledelivery.services.ProductInStoresService;
import com.yoursustainabledelivery.services.ProductService;
import com.yoursustainabledelivery.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @Autowired
    OrderService orderService;


    @RequestMapping(value = "/yourStore/{StoreId}", method = RequestMethod.GET)
    public ResponseEntity<Store> getStore(@PathVariable("StoreId") Long id) {

        Store store = storeService.getStore(id);

        return new ResponseEntity<Store>(store, HttpStatus.OK);

    }


    @RequestMapping(value = "/autoOrdering/{StoreId}", method = RequestMethod.GET)
    public ResponseEntity<String> autoOrder(@PathVariable("StoreId") Long id) {

        List<ProductInStore> list = productInStoresService.getListOfProductsInStore(id);

        for(int i = 0;i<list.size();i++) {
            ProductInStore bufforProduct = list.get(i);

            System.out.println("!!!!!!!!!!!!" + bufforProduct.getId_item());



            if (!bufforProduct.isBlock()) {


                if (bufforProduct.getInOrders() < bufforProduct.getMinSupply()
                        && bufforProduct.getQuanity() < bufforProduct.getMinSupply()) {


                    System.out.println("!!!!!!!!!!!! dziala");

                    Order order = new Order();
                    order.setId_item(bufforProduct.getId_item());
                    order.setId_store(id);

                    int orderQuanity = bufforProduct.getInOrders();
                    int count = 0;

                    while(orderQuanity < bufforProduct.getMinSupply()){

                       orderQuanity = orderQuanity + bufforProduct.getProductDetail().getInBox();
                       count++;
                    }

                        order.setQuanity(count*(bufforProduct.getProductDetail().getInBox()));

                        bufforProduct.setInOrders(bufforProduct.getInOrders()+order.getQuanity());

                    productInStoresService.updateProductInStore(bufforProduct);
                    orderService.addOrder(order);
                }
                }



        }
        return new ResponseEntity<String>("autoOrdering", HttpStatus.OK);

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
        String[] bufforCategoryArray = {"ACCESORIES", "DRINKS", "FOODS", "BIGHOUSEHOLDGOODS", "SMALLHOUSEHOLDGOODS", "RTV", "SMALLELECTRONICS", "COMPUTERS"};

        List<ProductInStore> productInStore = productInStoresService.getListOfProductsInStore(storeID);

        productInStoresService.updateProductInStoreBlock(storeID);

        for (int i = 0; i < edited.length; i++) {

            List<Product> bufforProductList = new ArrayList<>();


            if (Integer.valueOf(bufferRangeArray[i]) == 1) {
                bufforProductList = productService.getListProductsByRange(Integer.valueOf(bufferRangeArray[i]), bufforCategoryArray[i]);
            } else if (Integer.valueOf(bufferRangeArray[i]) == 2) {
                List<Product> aList = productService.getListProductsByRange(1, bufforCategoryArray[i]);
                List<Product> bList = productService.getListProductsByRange(2, bufforCategoryArray[i]);

                bufforProductList.addAll(aList);
                bufforProductList.addAll(bList);
            } else if (Integer.valueOf(bufferRangeArray[i]) == 3) {
                bufforProductList = productService.getListProductsCategory(bufforCategoryArray[i]);
            }


            for (int v = 0; v < bufforProductList.size(); v++) {

                Product bufforProduct = bufforProductList.get(v);

                ProductInStore productInStoreNew = new ProductInStore();

                productInStoreNew.setId_item(bufforProduct.getEan());
                productInStoreNew.setId_store(storeID);
                productInStoreNew.setQuanity(0);
                productInStoreNew.setMinSupply(bufforProduct.getInBox());
                productInStoreNew.setInOrders(0);
                productInStoreNew.setPrice(1.2 * (bufforProduct.getPurchasePrice()));
                productInStoreNew.setBlock(false);
                productInStoreNew.setProductDetail(bufforProduct);

                if (productInStoresService.isProductinStore(storeID, productInStoreNew.getId_item())) {

                    ProductInStore originalProductInStore = productInStoresService.getProductInStoreQuery(storeID, productInStoreNew.getId_item());

                    originalProductInStore.setBlock(false);
                    originalProductInStore.setMinSupply(productInStoreNew.getMinSupply());

                    productInStoresService.updateProductInStore(originalProductInStore);

                    rangeSetAutoOrder(storeID,originalProductInStore.getId_item());



                } else {

                    productInStoresService.addProductToStore(productInStoreNew);

                    rangeSetAutoOrder(storeID,productInStoreNew.getId_item());

                }


            }


        }


        return new ResponseEntity<String[]>(edited, HttpStatus.OK);
    }


    void rangeSetAutoOrder(Long storeId, Long itemId) {

        ProductInStore productInStoreBuffor = productInStoresService.getProductInStoreQuery(storeId, itemId);

        if (productInStoreBuffor.getInOrders() < productInStoreBuffor.getMinSupply()
                && productInStoreBuffor.getQuanity() < productInStoreBuffor.getMinSupply()) {


            if (!productInStoreBuffor.isBlock()) {


                if (productInStoreBuffor.getInOrders() < productInStoreBuffor.getMinSupply()
                        && productInStoreBuffor.getQuanity() < productInStoreBuffor.getMinSupply()) {


                    System.out.println("!!!!!!!!!!!! dziala");

                    Order order = new Order();
                    order.setId_item(productInStoreBuffor.getId_item());
                    order.setId_store(storeId);

                    int orderQuanity = productInStoreBuffor.getInOrders();
                    int count = 0;

                    while (orderQuanity < productInStoreBuffor.getMinSupply()) {

                        orderQuanity = orderQuanity + productInStoreBuffor.getProductDetail().getInBox();
                        count++;
                    }

                    order.setQuanity(count * (productInStoreBuffor.getProductDetail().getInBox()));

                    productInStoreBuffor.setInOrders(productInStoreBuffor.getInOrders() + order.getQuanity());


                    order.setCreated("AUTO");
                    productInStoresService.updateProductInStore(productInStoreBuffor);
                    orderService.addOrder(order);
                }
            }


        }

    }


}
