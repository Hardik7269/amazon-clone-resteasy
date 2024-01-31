package com.axelor.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ProductCatagory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catId;
	
	@Column
	private String electronicDevicse;
	@Column
	private String computersAccessories;
	@Column
	private String mobilePhones;
	
	
	@ManyToMany(mappedBy = "productCatagories")
	Set<ProductEntity> productEntitys = new HashSet<ProductEntity>();
	
	
	public Set<ProductEntity> getProductEntity() {
		return productEntitys;
	}
	public void setProductEntity(Set<ProductEntity> productEntity) {
		this.productEntitys = productEntity;
	}
	
	
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getElectronicDevicse() {
		return electronicDevicse;
	}
	public void setElectronicDevicse(String electronicDevicse) {
		this.electronicDevicse = electronicDevicse;
	}
	public String getComputersAccessories() {
		return computersAccessories;
	}
	public void setComputersAccessories(String computersAccessories) {
		this.computersAccessories = computersAccessories;
	}
	public String getMobilePhones() {
		return mobilePhones;
	}
	public void setMobilePhones(String mobilePhones) {
		this.mobilePhones = mobilePhones;
	}
	
	//sync for many to many
	public void addProductItems(ProductEntity productEntity) {
		getProductEntity().add(productEntity);
		
		productEntity.getProductCatagories().add(this);
	}
	
	public void removeProductItem(ProductEntity productEntity) {
		getProductEntity().remove(productEntity);
		productEntity.getProductCatagories().remove(this);
	}
	
}
