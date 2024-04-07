package com.axelor.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartNo;
    
    @Column
    private int cartQuantity;


	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<ProductEntity> products = new ArrayList<>();

	public int getCartQuantity() {
		return cartQuantity;
	}
	
	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
    public int getCartNo() {
        return cartNo;
    }

    public void setCartNo(int cartNo) {
        this.cartNo = cartNo;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public void addProduct(ProductEntity product) {
        products.add(product);
        product.setCart(this);
    }

    public void removeProduct(ProductEntity product) {
        products.remove(product);
        product.setCart(null);
    }
}
