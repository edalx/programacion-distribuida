package com.eacuji.config;

import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;


/**
 * Created by eacuji on 31/01/2018.
 */
@WebServlet(urlPatterns = "/rest/*",
        initParams = @WebInitParam(
                name = "jaxrs.serviceClasses",
                value = "com.eacuji.services.HelloServiceImpl"
        ))
public class ServletConfig extends CXFNonSpringJaxrsServlet {
}
