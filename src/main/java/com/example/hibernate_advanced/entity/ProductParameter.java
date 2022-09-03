package com.example.hibernate_advanced.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "productParameter")
    List<Product> products;
}
