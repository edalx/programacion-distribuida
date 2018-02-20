package com.eacuji.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by eacuji on 19/02/2018.
 */
@RestController
@RequestMapping(value = "/suma")
public class SumaController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{num1}/{num2}")
    public Integer suma(@PathVariable Integer num1, @PathVariable Integer num2){
        System.out.println("Sumando....");
        return num1+num2;
    }

}
