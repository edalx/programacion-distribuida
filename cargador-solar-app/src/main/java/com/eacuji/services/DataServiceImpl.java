package com.eacuji.services;

import com.eacuji.dao.DataRepository;
import com.eacuji.dto.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataRepository dataRepository;

    @Override
    public Data save(Data data) {
        dataRepository.save(data);
        return data;
    }

    @Override
    public Data findLast(Integer usb) {
        return dataRepository.findTopByUsbIdOrderByCreatedAtDesc(usb);
    }

    @Override
    public Iterable<Data> findAll() {
        return dataRepository.findAll();
    }
}
