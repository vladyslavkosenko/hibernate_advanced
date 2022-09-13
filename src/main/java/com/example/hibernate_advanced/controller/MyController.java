package com.example.hibernate_advanced.controller;


import com.example.hibernate_advanced.entity.Product;
import com.example.hibernate_advanced.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private final ProductService productService;

    public MyController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/products")
    public Iterable<Product> getProduct() {
        return productService.getProducts();
    }
}
