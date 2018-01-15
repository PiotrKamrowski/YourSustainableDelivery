package com.yoursustainabledelivery.controllers;


import com.yoursustainabledelivery.model.*;
import com.yoursustainabledelivery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController(value = "/users/")
@RequestMapping(value = "users")
public class UserController {


    @Autowired
    UserService userService;


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user) {


        User answer = user;

        userService.addUser(user);


        return new ResponseEntity<User>(answer, HttpStatus.OK);

    }


        @RequestMapping(value = "/editPermission", method = RequestMethod.POST)
        public ResponseEntity<Object> editPermission(@RequestBody String permission) {



        String[] buffer = permission.split(";");

            System.out.println(buffer[0]);
            System.out.println(buffer[1]);

        User user = userService.getUserById(buffer[1]);

        user.setPermission(Permission.valueOf(buffer[0]));

        userService.updateUser(user);


            return new ResponseEntity<Object>(permission, HttpStatus.OK);






        }


    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ResponseEntity<SmallUser> checkUser(@RequestBody SmallUser smallUser) {




       User user = userService.getUserById(smallUser.getLogin());

       String password = smallUser.getPassword();

        System.out.println("!!!!!!!!!!!!!!!!!!!!!"+smallUser);

        System.out.println("!!!!!!!!@#@#@#@#"+user.getUserPassword());

       if(user.getUserPassword().equals(password)){

         smallUser.setCorrectlogin(true);
            smallUser.setStoreId(user.getIdStore());
       }else {

           smallUser.setCorrectlogin(false);
       }
        System.out.println("22222222222222222222"+smallUser);

        return new ResponseEntity<SmallUser>(smallUser, HttpStatus.OK);


    }


    @RequestMapping(value = "/getStoresUsers/{StoreId}",method = RequestMethod.GET)
    public ResponseEntity<List<User>> getStore(@PathVariable("StoreId") Long id) {

        List<User> answer = userService.getUsersStoresList();

        return new ResponseEntity<List<User>>(answer, HttpStatus.OK);

    }


}





