package com.example.hibernate_advanced.service;

import com.example.hibernate_advanced.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
