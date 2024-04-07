package com.axelor.guiceModule;

import com.axelor.entity.CartEntity;
import com.axelor.entity.ProductCategory;
import com.axelor.entity.ProductEntity;
import com.axelor.redirecter.Redirect;
import com.axelor.service.ProductDetail;
import com.axelor.service.ProductDetailImpl;
import com.google.inject.AbstractModule;

public class GuiceModules extends AbstractModule{

	@Override
	protected void configure() {
		bind(ProductDetail.class).to(ProductDetailImpl.class);
		bind(ProductEntity.class);
		bind(CartEntity.class);
		bind(ProductCategory.class);
		bind(Redirect.class);
	}
	
}
