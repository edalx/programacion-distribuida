package com.eacuji.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.apache.cxf.jaxrs.swagger.Swagger2Feature;

import com.eacuji.services.HolaMundoImpl;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

// ver jaxrs.application.address.ignore en web.xml

@ApplicationPath("/app")
public class CxfApplication01 extends Application 
{

	@Override
	public Set<Class<?>> getClasses() {
		
		Set<Class<?>> classes = new HashSet<Class<?>>();
		
		classes.add( HolaMundoImpl.class );
		
		//providers
		classes.add( JacksonJsonProvider.class );
		
		// features
		classes.add( Swagger2Feature.class );
		
		return classes;
	}

}
