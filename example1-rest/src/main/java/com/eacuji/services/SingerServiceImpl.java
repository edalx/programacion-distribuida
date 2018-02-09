package com.eacuji.services;

import com.eacuji.dao.InstrumentDao;
import com.eacuji.dao.SingerDao;
import com.eacuji.dto.Singer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by eacuji on 25/12/2017.
 */
@SuppressWarnings("unchecked")
@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerDao singerDao;
    @Autowired
    private InstrumentDao instrumenDao;
    private static final Log logger = LogFactory.getLog(SingerServiceImpl.class);

    public List<Singer> findAll() {
        return singerDao.findAll();
    }

    public Singer findById(Long id) {
        return singerDao.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findByFirstName(String firstName) {
        return singerDao.findByFirstName(firstName);
    }

    @Override
    public List<Singer> findByInstrumentId(String instrumentId) {
        return singerDao.findByInstrumentId(instrumentId);
    }

    public Singer save(Singer singer) {
        singerDao.save(singer);
        logger.info("Singer saved with id: " + singer.getId());
        return singer;
    }

    public void delete(Singer singer) {
        singerDao.delete(singer);
    }
}
