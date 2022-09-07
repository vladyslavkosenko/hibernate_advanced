package com.example.hibernate_advanced.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String price;

    public Product() {
    }

    public Product(String price, String name) {
        this.price = price;
        this.name = name;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable
    private List<Category> categories;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ProductParameter> productParameter;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private ProductDescription productDescription;

    public void setProductParameter(ProductParameter productParameter) {
    }
}
