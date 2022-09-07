package com.example.hibernate_advanced.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String description;

    public ProductDescription(String description) {
        this.description = description;
    }

    public ProductDescription() {
    }

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Product product;
}
