package com.eacuji.services;

import com.eacuji.dao.SingerDao;
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
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerDao singerDao;
    private static final Log logger = LogFactory.getLog(SingerServiceImpl.class);


    public List<Singer> findAll() {
        return singerDao.findAll();
    }
    
    public Singer findById(Long id) {
        return singerDao.findById(id).get();
    }

    public Singer save(Singer singer) {
        return singerDao.save(singer);
    }

    public void delete(Singer singer) {
        singerDao.delete(singer);
    }
}
