package com.eacuji.mq;

import com.eacuji.config.DBConfig;
import com.eacuji.dto.Singer;
import com.eacuji.services.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SingerMqListener {
	private static Logger logger = LoggerFactory.getLogger(SingerMqListener.class);
	@Autowired
	private SingerService servicioSinger;
	
	@JmsListener(destination="/queue/singer", containerFactory="jmsListenerContainerFactory")
	public void artista( Singer singer ) {
		System.out.println( new Date() + ": Mensaje recibido, insertando singer: " + singer.toString() );
		servicioSinger.save( singer );
		logger.info("Lista de cantantes: ");
		logger.info(servicioSinger.findAll().toString());
	}

}
