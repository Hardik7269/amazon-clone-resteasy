package com.axelor.service;

import com.axelor.entity.CartEntity;
import com.axelor.entity.ProductCategory;
import com.axelor.entity.ProductEntity;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

public class ProductDetailImpl implements ProductDetail {

	
	private static final Map<String, String> categoryMap = new HashMap<>();

	Provider<EntityManager> emProvider;
    protected final ProductCategory category;
    protected final CartEntity cart;
    protected final ProductEntity product;
    
    @Inject
    public ProductDetailImpl(Provider<EntityManager> emProvider, ProductCategory category, CartEntity cart,
    		ProductEntity product) {
    	this.emProvider = emProvider;
    	this.category = category;
    	this.cart = cart;
    	this.product = product;
    }
    
	static {
        categoryMap.put("LG49\"CurvedUltragear™DualQHDGamingMonitor", "Monitor");
        categoryMap.put("AppleiPhone14ProMax(256GB)-DeepPurple", "Mobile Phone[IOS]");
        categoryMap.put("SamsungGalaxyS23Ultra5G(12GB,512GBStorage)", "Mobile Phone[Android]");
    }
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void addToCart(String pName, int pPrice, int pQuantity) {	
        EntityManager em = emProvider.get();

        product.setpName(pName);
        product.setpPrice(pPrice);
        product.setpQuantity(pQuantity);
        
        if(categoryMap.containsKey(pName)) {
        	category.setName(categoryMap.get(pName));
        }else {
        	category.setName("Default Category");
        }
        category.addProduct(product);

        cart.addProduct(product);

        em.persist(product);
        em.persist(category);	
        em.persist(cart);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void updateCartItem(int pId, String pName, int pPrice, int pQuantity) {
        EntityManager em = emProvider.get();

        ProductEntity product = em.find(ProductEntity.class, pId);
        product.setpName(pName);
        product.setpPrice(pPrice);
        product.setpQuantity(pQuantity);

        em.persist(product);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void removeProductItem(int pId) {
        EntityManager em = emProvider.get();

        ProductEntity product = em.find(ProductEntity.class, pId);
        em.remove(product);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void removeCart(int cId) {
        EntityManager em = emProvider.get();

        CartEntity cart = em.find(CartEntity.class, cId);
        em.remove(cart);
    }

	@Override
	@Transactional
	public void addAllProduct(int q1, int q2, int q3) {
		EntityManager em = emProvider.get();
		cart.setCartQuantity(q3+q2+q1);
		
		if(q1 != 0) {
			ProductEntity p = new ProductEntity();
			p.setCart(cart);
			p.setpQuantity(q1);
			p.setpName("Samsung Galaxy S23 Ultra 5G (12GB, 512GB Storage)");
			p.setpPrice(140000);
			cart.addProduct(p);
			em.persist(p);
		}
		if(q2 != 0) {
			ProductEntity p = new ProductEntity();
			p.setCart(cart);
			p.setpQuantity(q2);
			p.setpName("LG 49\" Curved Ultragear™ Dual QHD Gaming Monitor");
			p.setpPrice(90000);
			cart.addProduct(p);
			em.persist(p);
		}
		if(q3 != 0) {
			ProductEntity p = new ProductEntity();
			p.setCart(cart);
			p.setpQuantity(q3);
			p.setpName("Apple iPhone 14 Pro Max (256 GB) - Deep Purple");
			p.setpPrice(143000);
			cart.addProduct(p);
			em.persist(p);
		}
		
		em.persist(cart);
		
	}
    
    
}
