package com.eacuji.controllers.album;

import com.eacuji.entities.Album;
import com.eacuji.entities.Singer;
import com.eacuji.services.AlbumService;
import com.eacuji.services.SingerService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by eacuji on 30/12/2017.
 */
@ManagedBean
@ViewScoped
public class AdminAlbum implements Serializable {
    @ManagedProperty("#{singerService}")
    private SingerService singerService;
    @ManagedProperty("#{albumService}")
    private AlbumService albumService;
    private String singerId;
    private Album album;
    private List<Singer> singers;

    @PostConstruct
    private void postConstruct() {
        singers = singerService.findAll();
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        album = params.containsKey("album_id") ? albumService.
                findById(Long.parseLong(params.get("album_id"))) : new Album();
    }

    public void save() {
        Album albumInserted = albumService.save(album);
        Singer singerFound = singerService.findById(Long.parseLong(singerId));
        singerFound.addAbum(albumInserted);
        singerService.save(singerFound);
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("./index.xhtml");
        } catch (Exception e) {
        }
    }

    public void delete() {
        albumService.delete(album);
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("./index.xhtml");
        } catch (Exception e) {
        }
    }

    public List<Singer> getSingers() {
        return singers;
    }

    public void setSingers(List<Singer> singers) {
        this.singers = singers;
    }

    public SingerService getSingerService() {
        return singerService;
    }

    public void setSingerService(SingerService singerService) {
        this.singerService = singerService;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public AlbumService getAlbumService() {
        return albumService;
    }

    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    public String getSingerId() {
        return singerId;
    }

    public void setSingerId(String singerId) {
        this.singerId = singerId;
    }
}
