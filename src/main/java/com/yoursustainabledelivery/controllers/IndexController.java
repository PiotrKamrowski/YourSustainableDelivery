package com.yoursustainabledelivery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/view/")
public class IndexController {

    @RequestMapping("/getProductList")
    public String getProductList(){
        return "ProductList";
    }


}
