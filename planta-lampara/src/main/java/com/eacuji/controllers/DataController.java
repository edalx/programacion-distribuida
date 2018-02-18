package com.eacuji.controllers;

import com.eacuji.entities.Data;
import com.eacuji.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class DataController {
    @Autowired
    private DataService dataService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/")
    public Data create(@RequestBody Data data){
        dataService.save(data);
        return data;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/listdata")
    public List<Data> listData() {
        return dataService.findAll();
    }
}
