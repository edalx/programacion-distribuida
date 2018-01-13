package com.eacuji.config;

import com.eacuji.services.AlbumService;
import com.eacuji.services.InstrumentService;
import com.eacuji.services.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

/**
 * Created by eacuji on 25/12/2017.
 */
@Configuration
public class HttpInvokerConfig {

    @Autowired
    SingerService singerService;
    @Autowired
    InstrumentService instrumentService;
    @Autowired
    AlbumService albumService;

    @Bean(name = "/httpInvoker/singerService")
    public HttpInvokerServiceExporter httpInvokerSingerExporter() {
        HttpInvokerServiceExporter invokerService = new HttpInvokerServiceExporter();
        invokerService.setService(singerService);
        invokerService.setServiceInterface(SingerService.class);
        return invokerService;
    }

    @Bean(name = "/httpInvoker/instrumentService")
    public HttpInvokerServiceExporter httpInvokerInstrumenExporter() {
        HttpInvokerServiceExporter invokerService = new HttpInvokerServiceExporter();
        invokerService.setService(instrumentService);
        invokerService.setServiceInterface(InstrumentService.class);
        return invokerService;
    }

    @Bean(name = "/httpInvoker/albumService")
    public HttpInvokerServiceExporter httpInvokerAlbumExporter() {
        HttpInvokerServiceExporter invokerService = new HttpInvokerServiceExporter();
        invokerService.setService(albumService);
        invokerService.setServiceInterface(AlbumService.class);
        return invokerService;
    }

}