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
        ProductDescription productDescription = new ProductDescription("ProductDescription ");
        ProductParameter productParameter = new ProductParameter("ProductParameter ");
        Category category = new Category("Category ");
        product.setProductDescription(productDescription);
        product.setProductParameter(productParameter);
        product.setCategories(List.of(category));
        productRepository.saveAll(List.of(product));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }
}
