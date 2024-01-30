package com.axelor.listner;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.axelor.guiceModule.GuiceModules;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

public class RestGuiceListner extends GuiceResteasyBootstrapServletContextListener{

	@Override
	protected List<Module> getModules(ServletContext context) {

		return Arrays.asList(new GuiceModules(), new JpaPersistModule("RestEasy_Jpa"));
	}
	@Override
	protected void withInjector(Injector injector) {
		injector.getInstance(PersistService.class).start();
	}

	
		
}
