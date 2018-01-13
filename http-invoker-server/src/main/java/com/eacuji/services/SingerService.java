package com.eacuji.services;

import com.eacuji.entities.Instrument;
import com.eacuji.entities.Singer;

import java.util.List;

/**
 * Created by eacuji on 25/12/2017.
 */
public interface SingerService {

    List<Singer> findAll();

    Singer findById(Long id);

    List<Singer> findByInstrumentId(String instrumentId);

    Singer save(Singer singer);

    void delete(Singer singer);
}
