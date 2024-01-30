package com.axelor.service;

import javax.persistence.EntityManager;

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
		
		ProductEntity pe = new ProductEntity();

		
		
		pe.setpName(pName);
		pe.setpPrice(pPrice);
		pe.setpQuantity(pQuentity);
		
		
		em.persist(pe);

	}

}
