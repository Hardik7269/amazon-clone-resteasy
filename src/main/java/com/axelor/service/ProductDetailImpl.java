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
		
		EntityManager em = emProvider.get();		

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

		p1.addCart(cart);
		p2.addCart(cart);
		
	cart.addProductItem(p2);
	cart.addProductItem(p1);
	
		em.persist(cart);
//		em.persist(p2);
//		em.persist(p1);
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void updateCartItem(int pId, String pName, int pPrice, int pQuentity) {
		EntityManager em = emProvider.get();
		
		ProductEntity pe = em.find(ProductEntity.class, pId);
		pe.setpName(pName+" -> Updated Name");
		pe.setpPrice(pPrice);
		pe.setpQuantity(pQuentity);
		
		em.persist(pe);
		System.out.println("all done");
		
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void removeProductItem(int pId) {
		System.out.println("entered in remove product");
		EntityManager em = emProvider.get();
		
		ProductEntity pe = em.find(ProductEntity.class, pId);
		CartEntity ce = new CartEntity();
		ce.removeProductItem(pe);
		em.remove(pe);

		
	}

	@Override
	public void removeCart(int cId) {
		// TODO Auto-generated method stub
		
	}
	
	

}
