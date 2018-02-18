package com.eacuji.services;

import com.eacuji.entities.Data;

public interface DataService {

    Data save(Data data);
    Iterable<Data> findAll();
}
