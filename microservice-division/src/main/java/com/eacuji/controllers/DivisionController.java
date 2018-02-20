package com.eacuji.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by eacuji on 20/02/2018.
 */
@RestController
@RequestMapping(value = "/division")
public class DivisionController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{num1}/{num2}")
    public Float division(@PathVariable Integer num1, @PathVariable Integer num2){
        System.out.println("Dividiendo.....");
        float resultado=num1/num2;
        return resultado;
    }
}
