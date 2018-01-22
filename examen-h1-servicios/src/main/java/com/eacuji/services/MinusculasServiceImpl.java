package com.eacuji.services;

import org.springframework.stereotype.Service;

/**
 * Created by eacuji on 16/01/2018.
 */
@Service
public class MinusculasServiceImpl implements CadenaService {

    @Override
    public String procesarString(String cadena) {
        return cadena.toLowerCase();
    }
}
