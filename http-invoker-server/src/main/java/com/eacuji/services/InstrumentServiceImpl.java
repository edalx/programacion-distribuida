package com.eacuji.services;

import com.eacuji.dao.InstrumentDao;
import com.eacuji.dao.SingerDao;
import com.eacuji.entities.Instrument;
import com.eacuji.entities.Singer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eacuji on 25/12/2017.
 */
@SuppressWarnings("unchecked")
@Service
public class InstrumentServiceImpl implements InstrumentService {
    @Autowired
    private InstrumentDao instrumentDao;
    @Autowired
    private SingerDao singerDao;
    private static final Log logger = LogFactory.getLog(InstrumentServiceImpl.class);

    @Override
    public Instrument findById(String instrumentId) {
        return instrumentDao.findOne(instrumentId);
    }

    @Override
    public List<Instrument> findSingerId(Long id) {
        return instrumentDao.findBySingerId(id);
    }

    @Override
    public List<Instrument> findAll() {
        return instrumentDao.findAll();
    }

    @Override
    public Instrument save(Instrument instrument) {
        instrumentDao.save(instrument);
        return instrument;
    }

    @Override
    public void delete(Instrument instrument) {
        instrumentDao.delete(instrument);
    }
}
