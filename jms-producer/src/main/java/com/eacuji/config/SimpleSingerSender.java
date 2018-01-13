package com.eacuji.config;

import com.eacuji.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@Component("singerSender")
public class SimpleSingerSender implements SingerSender {
    private static final Logger logger = LoggerFactory.getLogger(SimpleSingerSender.class);
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendSinger(final Singer singer) {
        jmsTemplate.setDeliveryDelay(5000L);

        this.jmsTemplate.send(new MessageCreator() {
            @Override
            public ObjectMessage createMessage(Session session)
                    throws JMSException {
                ObjectMessage objectMessage  = session.createObjectMessage();
                objectMessage.setObject(singer);
                logger.info(">>> Sending: " + singer.toString());
                return objectMessage;
            }
        });
    }
}
