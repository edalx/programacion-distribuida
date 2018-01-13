package com.eacuji.web;

import com.eacuji.config.AppConfig;
import com.eacuji.config.SingerSender;
import com.eacuji.entities.Singer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by eacuji on 08/01/2018.
 */
@ManagedBean(name="singerAction")
@SessionScoped
public class SingerAction implements Serializable{
    private SingerSender servicio;
    private Singer singer;

    @PostConstruct
    public void init() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SingerSender singerSender = ctx.getBean("singerSender", SingerSender.class);
        servicio=singerSender;
        singer=new Singer();
    }
    public void send() {
        servicio.sendSinger(singer);
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("./index.xhtml");
        }catch (Exception e){
        }
    }

    public void limpiar(){
        singer.setLastName("");
        singer.setFirstName("");
        singer.setBirthDate(null);
    }
    public SingerSender getServicio() {
        return servicio;
    }

    public void setServicio(SingerSender servicio) {
        this.servicio = servicio;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }
}
