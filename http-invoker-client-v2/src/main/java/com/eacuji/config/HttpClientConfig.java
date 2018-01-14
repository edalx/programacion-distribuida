package com.eacuji.config;

import com.eacuji.services.SingerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

@Configuration
public class HttpClientConfig {

	/*@Bean
	public HttpInvokerProxyFactoryBean singerService() {
        HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
        proxy.setServiceUrl("http://localhost:8080/invoker/singer");
        proxy.setServiceInterface(SingerService.class);
        return proxy;
	}*/


    @Bean
    public HessianProxyFactoryBean singerService(){
        HessianProxyFactoryBean invoker=new HessianProxyFactoryBean();
        invoker.setServiceUrl("http://localhost:8080/invoker/singer");
        invoker.setServiceInterface(SingerService.class);
        return invoker;
    }

}
