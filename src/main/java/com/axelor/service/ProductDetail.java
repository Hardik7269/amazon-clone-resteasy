package com.axelor.service;

public interface ProductDetail {
	public void addToCart(String pName, int pPrice, int pQuentity);
	public void updateCartItem(int pId,String pName, int pPrice, int pQuentity);
	public void removeProductItem(int pId);
	public void removeCart(int cId);
	public void addAllProduct(int q1 , int q2 , int q3);
}
