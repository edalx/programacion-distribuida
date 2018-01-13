package com.eacuji.mq;

import com.eacuji.dto.Singer;
import org.springframework.stereotype.Component;

@Component(value="singerMqAdapter")
public class SingerMqAdapter {

    public void receive( Singer obj ) {
    	System.out.println( "Adapter-->" + obj.getLastName( ) );
    }

}
