package com.eacuji.config;

import org.apache.activemq.artemis.api.core.TransportConfiguration;
import org.apache.activemq.artemis.api.jms.ActiveMQJMSClient;
import org.apache.activemq.artemis.api.jms.JMSFactoryType;
import org.apache.activemq.artemis.core.remoting.impl.netty.NettyConnectorFactory;
import org.apache.activemq.artemis.core.remoting.impl.netty.TransportConstants;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJms
@ComponentScan("com.eacuji")
public class ArtemisMqConfig {

	@Bean
	ActiveMQQueue queueConsumidor() {
		return new ActiveMQQueue("/queue/consumidor");
	}

	@Bean
	ActiveMQQueue queueProductor() {
		return new ActiveMQQueue("/queue/productor");
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		Map<String, Object> connDetails = new HashMap<>();
		connDetails.put(TransportConstants.HOST_PROP_NAME, "0.0.0.0");
		connDetails.put(TransportConstants.PORT_PROP_NAME, "61616");
		connDetails.put(TransportConstants.PROTOCOLS_PROP_NAME, "tcp");
		TransportConfiguration transportConfiguration = new TransportConfiguration(
				NettyConnectorFactory.class.getName(), connDetails);
		return ActiveMQJMSClient.createConnectionFactoryWithoutHA(JMSFactoryType.CF,transportConfiguration);
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrency("3-10");
		return factory;
	}

	@Bean
	JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
		jmsTemplate.setDefaultDestination(queueConsumidor());
		return jmsTemplate;
	}

	@Bean
	JmsTemplate jmsTemplateRecive() {
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
		jmsTemplate.setDefaultDestination(queueProductor());
		return jmsTemplate;
	}


}
