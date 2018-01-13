package com.eacuji.services;

import com.eacuji.dao.AlbumDao;
import com.eacuji.entities.Album;
import com.eacuji.entities.Instrument;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by eacuji on 25/12/2017.
 */
@SuppressWarnings("unchecked")
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    private static final Log logger = LogFactory.getLog(AlbumServiceImpl.class);

    @Override
    public Album findById(Long id) {
        return albumDao.findOne(id);
    }

    @Override
    public List<Album> findSingerId(Long id) {
        return albumDao.findBySingerId(id);
    }

    @Override
    public List<Album> findAll() {
        return albumDao.findAll();
    }

    @Override
    public Album save(Album album) {
        albumDao.save(album);
        return album;
    }

    @Override
    public void delete(Album album) {
        albumDao.delete(album);
    }
}
