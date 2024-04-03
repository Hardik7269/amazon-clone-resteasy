package com.axelor.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;

    @Column
    private String pName;

    @Column
    private int pPrice;

    @Column
    private int pQuantity;

    @ManyToOne
    private CartEntity cart;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<ProductCategory> productCategories = new HashSet<>();

    public Set<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(Set<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }
}
