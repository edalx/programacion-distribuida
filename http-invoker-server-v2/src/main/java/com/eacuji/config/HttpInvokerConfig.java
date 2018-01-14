package com.eacuji.config;

import com.eacuji.services.SingerService;
import com.eacuji.services.SingerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianExporter;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

@Configuration
public class HttpInvokerConfig {
	@Autowired
	SingerServiceImpl singerService;

	/*
	@Bean(name = "/singer")
	public HttpInvokerServiceExporter  singerHttpInvokerServiceExporter() {
		HttpInvokerServiceExporter  invokerService = new HttpInvokerServiceExporter();
		invokerService.setService(singerService);
		invokerService.setServiceInterface(SingerService.class);
		return invokerService;
	}*/


	@Bean(name = "/singer")
	public HessianServiceExporter  singerHttpInvokerServiceExporter() {
		HessianServiceExporter  invokerService = new HessianServiceExporter();
		invokerService.setService(singerService);
		invokerService.setServiceInterface(SingerService.class);
		return invokerService;
	}


}
