package com.eacuji.controllers.album;

import com.eacuji.entities.Album;
import com.eacuji.services.AlbumService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by eacuji on 28/12/2017.
 */
@ManagedBean
@ViewScoped
public class ListarAlbum {
    @ManagedProperty("#{albumService}")
    private AlbumService albumService;
    private List<Album> albums;

    @PostConstruct
    public void postConstruct(){
        albums=albumService.findAll();
    }

    public AlbumService getAlbumService() {
        return albumService;
    }

    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
