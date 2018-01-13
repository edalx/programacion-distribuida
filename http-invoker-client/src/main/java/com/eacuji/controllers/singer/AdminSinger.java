package com.eacuji.controllers.singer;

import com.eacuji.entities.Album;
import com.eacuji.entities.Instrument;
import com.eacuji.entities.Singer;
import com.eacuji.services.AlbumService;
import com.eacuji.services.InstrumentService;
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
 * Created by eacuji on 25/12/2017.
 */
@ManagedBean
@ViewScoped
public class AdminSinger implements Serializable {
    @ManagedProperty("#{singerService}")
    private SingerService singerService;
    @ManagedProperty("#{albumService}")
    private AlbumService albumService;
    @ManagedProperty("#{instrumentService}")
    private InstrumentService instrumentService;
    private Singer singer;
    private List<Album> albums;
    private List<Instrument> instruments;

    @PostConstruct
    private void postConstruct() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        singer = params.containsKey("singer_id") ? singerService.
                findById(Long.parseLong(params.get("singer_id"))) : new Singer();
    }

    public void save() {
        singerService.save(singer);
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("./index.xhtml");
        }catch (Exception e){
        }
    }

    public void delete() {
        singerService.delete(singer);
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("./index.xhtml");
        }catch (Exception e){
        }
    }

    public SingerService getSingerService() {
        return singerService;
    }

    public void setSingerService(SingerService singerService) {
        this.singerService = singerService;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public AlbumService getAlbumService() {
        return albumService;
    }

    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    public InstrumentService getInstrumentService() {
        return instrumentService;
    }

    public void setInstrumentService(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    public List<Album> getAlbums() {
        return albumService.findSingerId(singer.getId());
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Instrument> getInstruments() {
        return instrumentService.findSingerId(singer.getId());
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }
}
