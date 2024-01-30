package com.axelor.service;

import java.util.*;


import javax.persistence.EntityManager;

import com.axelor.entity.CartEntity;
import com.axelor.entity.ProductEntity;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

public class ProductDetailImpl implements ProductDetail{
	@Inject
	Provider<EntityManager> emProvider;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void addToCartt(String pName, int pPrice, int pQuentity) {
		
		System.out.println("02");
		EntityManager em = emProvider.get();		
		System.out.println("03");
		ProductEntity p1 = new ProductEntity();
		ProductEntity p2 = new ProductEntity();
		
		
		CartEntity cart = new CartEntity();

		List<ProductEntity> products = new ArrayList<ProductEntity>();

		p1.setpName(pName);
		p1.setpPrice(pPrice);

		p1.setpQuantity(pQuentity);

		
		p2.setpName(pName+"second");
		p2.setpPrice(pPrice+1000);
		p2.setpQuantity(pQuentity+2);
		
		products.add(p2);
		products.add(p1);
		System.out.println("4");
		p1.addCart(cart);
		p2.addCart(cart);
		
	cart.addProductItem(p2);
	cart.addProductItem(p1);
	

		
		em.persist(cart);
		em.persist(p2);
		em.persist(p1);
	}

}
