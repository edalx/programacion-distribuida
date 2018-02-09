package eacuji.config;


import eacuji.services.HelloServiceImpl;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by eacuji on 01/02/2018.
 */
@Configuration
@ComponentScan(basePackages = {"com.eacuji"})
public class CxfConfig {
    @Bean
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    public Server rsServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(cxf());
        endpoint.setAddress("/");
        endpoint.setServiceBeans(Arrays.<Object>asList(new HelloServiceImpl()));
        return endpoint.create();
    }

}
