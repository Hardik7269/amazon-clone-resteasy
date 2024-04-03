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
		getProducts().add(product);
		product.setCart(this);
	}
	
	
	
	public void removeProductItem(ProductEntity product) {
		System.out.println("001");
//		if(getProducts().size() == 0) {
//			System.out.println("Empty Cart");
//			return ;
//		}
//		System.out.println("002");
//		//handeling the category's from the product
//		Set<ProductCatagory> pc = product.getProductCatagories();
//		System.out.println("003");
//		for(ProductCatagory oneCategory : pc) {
//			System.out.println("000");
//			product.removeProductCatagorySet(oneCategory);
//		}
//		System.out.println("004");
		getProducts().remove(product);
		product.setCart(null);
	}
	
}
