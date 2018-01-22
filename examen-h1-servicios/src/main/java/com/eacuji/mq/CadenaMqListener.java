package com.eacuji.mq;

import com.eacuji.services.CadenaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;
import java.util.Date;

/**
 * Created by eacuji on 16/01/2018.
 */
@Service
public class CadenaMqListener {
    private static Logger logger = LoggerFactory.getLogger(CadenaMqListener.class);
    @Autowired @Qualifier("mayusculasServiceImpl")
    private CadenaService mayusculasService;
    @Autowired @Qualifier("minusculasServiceImpl")
    private CadenaService minusculasService;
    @Autowired @Qualifier("invertirServiceImpl")
    private CadenaService invertirService;
    @Autowired
    private JmsTemplate jmsTemplate;


   @JmsListener(destination="/queue/consumidor", containerFactory="jmsListenerContainerFactory")
    public void servicio( String cadena ) {
        System.out.println( new Date() + ": Mensaje recibido, insertando singer: " + cadena);
        logger.info(">>>>>>>>>Mensaje recibido");
        logger.info(cadena);
        String[] opCadena=cadena.split(",");
        String text=opCadena[0];
        Integer op=Integer.parseInt(opCadena[1]);
       System.out.println();
        switch (op){
            case 1:
                send(mayusculasService.procesarString(text));
                break;
            case 2:
                send(minusculasService.procesarString(text));
                break;
            case 3:
                send(invertirService.procesarString(text));
                break;
        }
    }

    public String send(String cadena) {
        jmsTemplate.send(
                (session) -> {
                    TextMessage jmsMessage = session.createTextMessage(cadena);
                    System.out.println(">>> Enviando: " + cadena);
                    return jmsMessage;
                }
        );
        return "index";
    }

}
