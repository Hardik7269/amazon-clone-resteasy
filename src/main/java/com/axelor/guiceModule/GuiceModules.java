package com.axelor.guiceModule;

import com.axelor.redirecter.Redirect;
import com.axelor.service.ProductDetail;
import com.axelor.service.ProductDetailImpl;
import com.google.inject.AbstractModule;

public class GuiceModules extends AbstractModule{

	@Override
	protected void configure() {
		bind(ProductDetail.class).to(ProductDetailImpl.class);

		bind(Redirect.class);
	}
	
}
