package com.axelor.service;

import java.util.*;


import javax.persistence.EntityManager;

import com.axelor.entity.CartEntity;
import com.axelor.entity.ProductCatagory;
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
		System.out.println("01");

		ProductEntity p1 = new ProductEntity();
		ProductEntity p2 = new ProductEntity();
		ProductCatagory catagory1 = new ProductCatagory();
		ProductCatagory catagory2 = new ProductCatagory();
//		ProductCatagory catagory3 = new ProductCatagory();
		
		System.out.println("02");
		
		CartEntity cart = new CartEntity();
		
		System.out.println("03");
		
		
		catagory1.setComputersAccessories(pName);
		catagory1.setElectronicDevicse(pName);
		catagory1.setMobilePhones(pName);
		catagory2.setMobilePhones(pName+" another");
		catagory2.setElectronicDevicse(pName + " another");
		catagory2.setComputersAccessories(pName + " another");
		
		System.out.println("04");

		p1.setpName(pName);
		p1.setpPrice(pPrice);
	
		System.out.println("05");

		p1.setpQuantity(pQuentity);

		System.out.println("06");
		
		p2.setpName(pName+" another");
		p2.setpPrice(pPrice+1000);
		p2.setpQuantity(pQuentity+2);
		
		System.out.println("07");
		
//		catAll.add(catagory2);
//		catAll.add(catagory1);
		
		System.out.println("08");
		
		catagory1.addProductItems(p1);
		catagory1.addProductItems(p2);
		catagory2.addProductItems(p2);
		catagory2.addProductItems(p1);
		
		System.out.println("09");
		
		
//		p1.setProductCatagories(catAll);
//		p2.setProductCatagories(catAll);
		
		System.out.println("104");
		
		//sync product to catagory
//		p1.addProductCatagory(catagory2);
//		p1.addProductCatagory(catagory1);
//		p2.addProductCatagory(catagory2);
		
//		products.add(p2);
//		products.add(p1);



		
	//sync from cart to product
	cart.addProductItem(p2);
	cart.addProductItem(p1);
	
	System.out.println("14");
	
		
		System.out.println("141");
//		em.persist(p2);
//		em.persist(p1);
		System.out.println("done");
//		em.persist(catagory1);
		System.out.println("11");
//		em.persist(catagory2);
		em.persist(cart);
		System.out.println("20");
		
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
		System.out.println("here till");

		
	}

	@Override
	public void removeCart(int cId) {
		
		CartEntity ce = emProvider.get().find(CartEntity.class, cId);	
		
		List<ProductEntity> peList=  ce.getProducts();
		
		for(ProductEntity pe : peList) {
			System.out.println("00");
			ce.removeProductItem(pe);
		}		
		
		/*System.out.println("01");
		//getting the product entity of the associate particular cart id		
		System.out.println("02");
		System.out.println("03");
		if(ce != null) {
			List<ProductEntity> list = ce.getProducts();			
			for (ProductEntity product : list) {
				product.getCart().removeProductItem(product);
			}
		}
		System.out.println("04");*/
	}

}
