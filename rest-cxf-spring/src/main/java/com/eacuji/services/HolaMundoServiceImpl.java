package com.eacuji.services;

import org.springframework.stereotype.Service;

/**
 * Created by eacuji on 08/02/2018.
 */
@Service
public class HolaMundoServiceImpl implements HolaMundoService {

    @Override
    public String holaMundo(String nombre){
        return "Hola "+nombre;
    }
}
