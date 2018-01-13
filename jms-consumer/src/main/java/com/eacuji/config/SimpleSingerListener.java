package com.eacuji.config;

import com.eacuji.entities.Singer;
import com.eacuji.services.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

@Component("singerListener")
public class SimpleSingerListener {
    @Autowired
    private SingerService singerDao;
    private static final Logger logger = LoggerFactory.getLogger(SimpleSingerListener.class);

    @JmsListener(destination = "distribuida", containerFactory = "jmsListenerContainerFactory")
    public void onMessage(Message message) throws JMSException {
        ObjectMessage objectMessage = (ObjectMessage) message;
        Singer singer=(Singer)objectMessage.getObject();

        try {
            logger.info(">>> Received: " + singer.toString());
            singerDao.save(singer);
            logger.info(">>>Objetos insertados:");
            logger.info(singerDao.findAll().toString());
        } catch (Exception ex) {
            logger.error("JMS error", ex);
        }
    }
}
