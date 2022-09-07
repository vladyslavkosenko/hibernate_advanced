package com.example.hibernate_advanced.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String category;

    public Category(String category) {
        this.category = category;
    }

    public Category() {
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn
    private List <Product> product;
}
