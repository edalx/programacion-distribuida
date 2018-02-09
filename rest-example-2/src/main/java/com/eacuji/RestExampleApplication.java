package com.eacuji;

import com.eacuji.dao.SingerDao;
import com.eacuji.services.SingerService;
import com.eacuji.services.SingerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Created by eacuji on 29/01/2018.
 */
@SpringBootApplication(scanBasePackages = "com.eacuji")
public class RestExampleApplication {
    private static Logger logger = LoggerFactory.getLogger(RestExampleApplication.class);


    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = SpringApplication.run(RestExampleApplication.class, args);
        assert (ctx != null);
        logger.info("Application Started ...");
        SingerService singerService=ctx.getBean("singerService", SingerService.class);
        System.out.println(singerService.findAll().toString());
        System.in.read();
        ctx.close();
    }
}
