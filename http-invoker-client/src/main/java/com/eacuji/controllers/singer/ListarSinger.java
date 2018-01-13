package com.eacuji.controllers.singer;


import com.eacuji.entities.Singer;
import com.eacuji.services.SingerService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;


/**
 * Created by eacuji on 28/12/2017.
 */
@ManagedBean
@ViewScoped
public class ListarSinger implements Serializable {
    @ManagedProperty("#{singerService}")
    private SingerService singerService;
    private List<Singer> singers;


    @PostConstruct
    private void postConstruct() {
        singers = singerService.findAll();
    }

    public SingerService getSingerService() {return singerService;}

    public void setSingerService(SingerService singerService) {
        this.singerService = singerService;
    }

    public List<Singer> getSingers() {
        return singers;
    }

    public void setSingers(List<Singer> singers) {
        this.singers = singers;
    }

}
