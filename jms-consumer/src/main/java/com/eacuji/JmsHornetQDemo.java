package com.eacuji;

import com.eacuji.config.AppConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;


public class JmsHornetQDemo {
    private static final Log logger = LogFactory.getLog(JmsHornetQDemo.class);

    public static void main(String... args) throws Exception{
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        System.in.read();
        ctx.close();
    }
}
