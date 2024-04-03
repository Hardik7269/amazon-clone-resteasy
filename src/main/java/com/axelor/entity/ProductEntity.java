package com.axelor.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.*;

import com.google.inject.Inject;

@Entity
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int pId;
	@Column
	String pName;
	
	@Column
	int pPrice;
	@Column
	int pQuantity;

	@ManyToOne
	CartEntity cart;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "productEntitys")
	Set<ProductCatagory> productCatagories = new HashSet<ProductCatagory>();
	
	public Set<ProductCatagory> getProductCatagories() {
		return productCatagories;
	}
	public void setProductCatagories(Set<ProductCatagory> productCatagories) {
		this.productCatagories = productCatagories;
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
	
	//sync
	public void addProductCatagorySet(ProductCatagory categoty) {
		getProductCatagories().add(categoty);
		
		categoty.getProductEntity().add(this);
	}
	
	public void removeProductCatagorySet(ProductCatagory category) {
		System.out.println("0001");
		
		if(category != null) {
			System.out.println("0002.1");

			getProductCatagories().remove(category);
			category.getProductEntity().remove(this);
		}
		System.out.println("0002");
	}
	

	
}
