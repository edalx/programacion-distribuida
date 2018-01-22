package com.eacuji;

import com.eacuji.config.ArtemisMqConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;


public class ArtemisRun {
    private static final Log logger = LogFactory.getLog(ArtemisRun.class);

    public static void main(String... args) throws Exception{
        logger.info("Inicializando contexto....");
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ArtemisMqConfig.class);
        System.in.read();
        ctx.close();
    }
}
