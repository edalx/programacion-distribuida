package com.eacuji.config;

import com.eacuji.mq.SingerMqAdapter;
import org.apache.activemq.artemis.api.core.TransportConfiguration;
import org.apache.activemq.artemis.api.jms.ActiveMQJMSClient;
import org.apache.activemq.artemis.api.jms.JMSFactoryType;
import org.apache.activemq.artemis.core.remoting.impl.netty.NettyConnectorFactory;
import org.apache.activemq.artemis.core.remoting.impl.netty.TransportConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJms
public class ArtemisMqConfig {

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


	//02. -- configuracion adapter
	@Bean
	public DefaultMessageListenerContainer singerContainer(
		ConnectionFactory connectionFactory,
		MessageListenerAdapter singerAdapter ) {

		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer( );
		container.setDestinationName( "/queue/singer" );
		container.setConnectionFactory( connectionFactory );
		container.setMessageListener( singerAdapter );

		return container;
	}

	@Bean
	public MessageListenerAdapter singerAdapter( SingerMqAdapter singerAdapter ) {
		MessageListenerAdapter adapter = new MessageListenerAdapter( singerAdapter );
		adapter.setDefaultListenerMethod( "receive" );
		return adapter;
	}
}
