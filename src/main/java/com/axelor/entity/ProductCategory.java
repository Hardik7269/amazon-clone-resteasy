package com.axelor.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "productCategories", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ProductEntity> products = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }

    public void addProduct(ProductEntity product) {
        products.add(product);
        product.getProductCategories().add(this);
    }

    public void removeProduct(ProductEntity product) {
        products.remove(product);
        product.getProductCategories().remove(this);
    }
}
