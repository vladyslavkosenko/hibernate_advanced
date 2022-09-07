package com.example.hibernate_advanced.controller;


import com.example.hibernate_advanced.entity.Product;
import com.example.hibernate_advanced.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }


    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product) {
        return myService.createProduct(product);
    }

    @GetMapping("/products")
    public Iterable<Product> getProduct() {
        return myService.getProducts();
    }
}
