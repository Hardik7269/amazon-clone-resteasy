package com.axelor.service;

import com.axelor.entity.CartEntity;
import com.axelor.entity.ProductCategory;
import com.axelor.entity.ProductEntity;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

public class ProductDetailImpl implements ProductDetail {

    @Inject
    Provider<EntityManager> emProvider;

    private static final Map<String, String> categoryMap = new HashMap<>();

    static {
        categoryMap.put("LG49\"CurvedUltragear™DualQHDGamingMonitor", "Monitor");
        categoryMap.put("AppleiPhone14ProMax(256GB)-DeepPurple", "Mobile Phone[IOS]");
        categoryMap.put("SamsungGalaxyS23Ultra5G(12GB,512GBStorage)", "Mobile Phone[Android]");
    }
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void addToCart(String pName, int pPrice, int pQuantity) {	
        EntityManager em = emProvider.get();

        ProductEntity product = new ProductEntity();
        product.setpName(pName);
        product.setpPrice(pPrice);
        product.setpQuantity(pQuantity);

        ProductCategory category = new ProductCategory();
        if(categoryMap.containsKey(pName)) {
        	category.setName(categoryMap.get(pName));
        }else {
        	category.setName("Default Category");
        }
        category.addProduct(product);

        CartEntity cart = new CartEntity();
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
}
