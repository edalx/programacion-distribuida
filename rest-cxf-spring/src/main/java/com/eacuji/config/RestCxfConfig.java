package com.eacuji.config;

import com.eacuji.services.HolaMundoService;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.spring.JAXRSServerFactoryBeanDefinitionParser.SpringJAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;

@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml", })
@ComponentScan(basePackages = "com.eacuji.services")
public class RestCxfConfig {

    @Autowired private SpringBus bus;
    @Autowired private HolaMundoService service;

    @Bean
    public JacksonJsonProvider jsonProvider() {
        return new JacksonJsonProvider();
    }

    @Bean
    public Server bean01()
    {
        SpringJAXRSServerFactoryBean endpoint = new SpringJAXRSServerFactoryBean( );
        endpoint.setServiceBeans(Arrays.<Object>asList(service)); //Aqui se puede anadir mas servicios ej: ( service, servicioPersonas )
        endpoint.setAddress("/");
        endpoint.setProvider(jsonProvider());
        return endpoint.create();
    }
}