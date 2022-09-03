package com.example.hibernate_advanced.controller;

import com.example.hibernate_advanced.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }
    @PostMapping("/products")
    public void createProduct() {

    }

}
