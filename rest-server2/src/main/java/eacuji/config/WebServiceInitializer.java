package eacuji.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by iuliana.cosmina on 10/16/16.
 */
public class WebServiceInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                CxfConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/rest/*"};
    }
}