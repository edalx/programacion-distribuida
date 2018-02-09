package eacuji.services;

import org.springframework.stereotype.Component;

/**
 * Created by eacuji on 31/01/2018.
 */

@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String helloWorld(String nombre) {
        return "Hola "+nombre;
    }
}
