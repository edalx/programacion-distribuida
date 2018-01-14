package com.eacuji.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Inicializar la aplicaci�n WEB
 * @author jsalvador
 *
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class<?>[] { DBConfig.class };

	}

	// web appContext
	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class<?>[] { WebConfig.class, HttpInvokerConfig.class};
	}

	@Override
	protected String[] getServletMappings() {

		 return new String[]{"/invoker/*"};
	}
	
	 @Override
	 protected Filter[] getServletFilters() {
	   
		 CharacterEncodingFilter cef = new CharacterEncodingFilter();
		 cef.setEncoding("UTF-8");
		 cef.setForceEncoding(true);
	   
		 return new Filter[]{new HiddenHttpMethodFilter(), cef};
	 }


}
