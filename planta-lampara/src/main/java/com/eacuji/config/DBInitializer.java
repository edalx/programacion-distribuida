package com.eacuji.config;

import com.eacuji.dao.DataRepository;
import com.eacuji.entities.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DBInitializer {
    @Autowired
    private DataRepository dataRepository;

    @PostConstruct
    public void initDB(){
        Data dato=new Data();
        dato.setId(1L);
        dato.setDuracion(3600L);
        dataRepository.save(dato);
    }
}
