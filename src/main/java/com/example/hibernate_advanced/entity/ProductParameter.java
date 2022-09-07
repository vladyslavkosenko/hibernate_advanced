package com.example.hibernate_advanced.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String parameter;

    public ProductParameter(String parameter) {
        this.parameter = parameter;
    }

    public ProductParameter() {
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn
    private Product product;
}
