package com.eacuji.controllers;

import com.eacuji.dto.Data;
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
    public Data create(@RequestBody Data data){
        if(data.getEstado().equals("on")){
            data.setDuracion(0L);
            dataService.save(data);
        }else{
               Data temp=dataService.findLast(data.getUsbId());
               Date fechaOut=new Date();
               long in=temp.getCreatedAt().getTime();
               long out=fechaOut.getTime();
               long diff=(out-in)/1000;
               data.setDuracion(diff);
               dataService.save(data);
        }
        return data;
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
