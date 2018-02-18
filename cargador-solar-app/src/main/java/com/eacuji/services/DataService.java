package com.eacuji.services;

import com.eacuji.dto.Data;

import java.util.List;

public interface DataService {

    Data save(Data data);
    List<Data> findAll();
}
