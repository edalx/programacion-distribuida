package com.eacuji.services;

import com.eacuji.entities.Album;
import com.eacuji.entities.Instrument;

import java.util.List;

/**
 * Created by eacuji on 25/12/2017.
 */
public interface AlbumService {

    Album findById(Long id);

    List<Album> findSingerId(Long id);

    List<Album> findAll();

    Album save(Album a);

    void delete(Album a);

}
