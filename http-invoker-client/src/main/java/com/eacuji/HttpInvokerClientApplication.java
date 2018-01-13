package com.eacuji;

import com.eacuji.services.AlbumService;
import com.eacuji.services.InstrumentService;
import com.eacuji.services.SingerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

@SpringBootApplication
public class HttpInvokerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpInvokerClientApplication.class, args);
	}

	@Bean("singerService")
	public SingerService singerService() {
		HttpInvokerProxyFactoryBean factoryBean = new HttpInvokerProxyFactoryBean();
		factoryBean.setServiceInterface(SingerService.class);
		factoryBean.setServiceUrl("http://localhost:8080/httpInvoker/singerService");
		factoryBean.afterPropertiesSet();
		return (SingerService) factoryBean.getObject();
	}

	@Bean("instrumentService")
	public InstrumentService instrumentService() {
		HttpInvokerProxyFactoryBean factoryBean = new HttpInvokerProxyFactoryBean();
		factoryBean.setServiceInterface(InstrumentService.class);
		factoryBean.setServiceUrl("http://localhost:8080/httpInvoker/instrumentService");
		factoryBean.afterPropertiesSet();
		return (InstrumentService) factoryBean.getObject();
	}

	@Bean("albumService")
	public AlbumService albumService() {
		HttpInvokerProxyFactoryBean factoryBean = new HttpInvokerProxyFactoryBean();
		factoryBean.setServiceInterface(AlbumService.class);
		factoryBean.setServiceUrl("http://localhost:8080/httpInvoker/albumService");
		factoryBean.afterPropertiesSet();
		return (AlbumService) factoryBean.getObject();
	}
}
