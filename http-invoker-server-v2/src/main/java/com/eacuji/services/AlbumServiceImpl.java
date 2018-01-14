package com.eacuji.services;

import com.eacuji.dao.AlbumDao;
import com.eacuji.dto.Album;
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
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    private static final Log logger = LogFactory.getLog(AlbumServiceImpl.class);

    @Override
    @Transactional(readOnly = true)
    public Album findById(Long id) {
        return albumDao.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Album> findSingerId(Long id) {
        return albumDao.findBySingerId(id);
    }

    @Override
    @Transactional(readOnly = true)
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
