package com.axelor.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CartEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int CartNo;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "cart")
	List<ProductEntity> products = new ArrayList<ProductEntity>();
	
	

	public int getCartNo() {
		return CartNo;
	}

	public void setCartNo(int cartNo) {
		CartNo = cartNo;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
	
	public void addProductItem(ProductEntity product) {
//		getProducts().add(product);
		List<ProductEntity> list = new ArrayList<>(this.getProducts());
		list.add(product);
		product.setCart(this);
	}
	
	public void removeProductItem(ProductEntity product) {
		getProducts().remove(product);
		product.setCart(null);
	}
	
}
