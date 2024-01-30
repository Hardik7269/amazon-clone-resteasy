package com.axelor.entity;

import java.util.Set;

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
	Set<ProductEntity> products;
	
	

	public int getCartNo() {
		return CartNo;
	}

	public void setCartNo(int cartNo) {
		CartNo = cartNo;
	}

	public Set<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}
	
}
