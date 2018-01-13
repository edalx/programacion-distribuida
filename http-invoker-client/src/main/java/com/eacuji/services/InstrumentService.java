package com.eacuji.services;

import com.eacuji.entities.Instrument;

import java.util.List;

/**
 * Created by eacuji on 25/12/2017.
 */
public interface InstrumentService {

    Instrument findById(String instrumentId);

    List<Instrument> findSingerId(Long id);

    List<Instrument> findAll();

    Instrument save(Instrument instrument);

    void delete(Instrument instrument);
}
