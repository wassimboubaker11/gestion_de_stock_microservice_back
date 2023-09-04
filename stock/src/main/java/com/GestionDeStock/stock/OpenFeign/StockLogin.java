package com.GestionDeStock.stock.OpenFeign;


import com.GestionDeStock.stock.Entity.User;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="Stock-Login" , url ="${application.config.login-url}")
public interface StockLogin {

   @DeleteMapping("/deleteUserByEmail/{email}")
       void deleteUserByEmail (@PathVariable("email") String email);


    @PostMapping("/saveUser")
    User createUser(@RequestBody User user);


    }

