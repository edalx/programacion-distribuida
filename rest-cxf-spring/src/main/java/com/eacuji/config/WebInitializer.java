package com.eacuji.config;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


/**
 * Created by eacuji on 08/02/2018.
 */
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println( "Inicializando contexto..." );
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext( );
        context.register( RestCxfConfig.class );
        servletContext.addListener( new ContextLoaderListener(context) );
        ServletRegistration.Dynamic cxf
                = servletContext.addServlet("cxf", new CXFServlet());
        cxf.setLoadOnStartup( 1 );
        cxf.addMapping( "/services/*" );
    }
}

