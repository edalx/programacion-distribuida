package com.eacuji.services;

/**
 * Created by eacuji on 31/01/2018.
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String helloWorld(String nombre) {
        return "Hola "+nombre;
    }
}
