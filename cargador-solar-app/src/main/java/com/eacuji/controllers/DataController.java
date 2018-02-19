package com.eacuji.controllers;

import com.eacuji.dto.Data;
import com.eacuji.dto.DataTemp;
import com.eacuji.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping(value = "/api")
public class DataController {
    @Autowired
    private DataService dataService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/")
    public Data create(@RequestBody DataTemp data) {
        String usbId = data.getDato().split("-")[0];
        String estado = data.getDato().split("-")[1];
        Data nuevoDato = new Data();
        nuevoDato.setUsbId(Integer.parseInt(usbId));
        nuevoDato.setEstado(estado);
        if (nuevoDato.getEstado().equals("on")) {
            nuevoDato.setDuracion(0L);
            dataService.save(nuevoDato);
        } else {
            Data temp = dataService.findLast(nuevoDato.getUsbId());
            Date fechaOut = new Date();
            long in = temp.getCreatedAt().getTime();
            long out = fechaOut.getTime();
            long diff = (out - in) / 1000;
            nuevoDato.setDuracion(diff);
            dataService.save(nuevoDato);
        }
        System.out.println("Dato insertado: "+nuevoDato.toString());
        return nuevoDato;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/listdata")
    public Iterable<Data> listData() {
        return dataService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{usbId}")
    public Data last(@PathVariable Integer usbId) {
        return dataService.findLast(usbId);
    }

}
