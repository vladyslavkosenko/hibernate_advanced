package com.example.hibernate_advanced.service;

import com.example.hibernate_advanced.entity.Category;
import com.example.hibernate_advanced.entity.Product;
import com.example.hibernate_advanced.entity.ProductDescription;
import com.example.hibernate_advanced.entity.ProductParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    void init() {
        Product product = new Product("10", "name");
        Product product1 = new Product("20", "newName");
        ProductDescription productDescription = new ProductDescription("ProductDescription 0");
        ProductDescription productDescription1 = new ProductDescription("ProductDescription 1");
        ProductParameter productParameter = new ProductParameter("ProductParameter 0");
        ProductParameter productParameter1 = new ProductParameter("ProductParameter 1");
        Category category = new Category("Category 0");
        Category category1 = new Category("Category 1");
        product.setProductDescription(productDescription);
        product.setProductParameter(productParameter);
        product.setCategories(List.of(category, category1));
        product1.setProductDescription(productDescription1);
        product1.setProductParameter(productParameter1);
        product1.setCategories(List.of(category, category1));
        productRepository.saveAll(List.of(product));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }
}
