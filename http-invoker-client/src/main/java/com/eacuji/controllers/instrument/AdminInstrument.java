package com.eacuji.controllers.instrument;

import com.eacuji.entities.Instrument;
import com.eacuji.entities.Singer;
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
 * Created by eacuji on 30/12/2017.
 */
@ManagedBean
@ViewScoped
public class AdminInstrument implements Serializable {
    @ManagedProperty("#{singerService}")
    private SingerService singerService;
    @ManagedProperty("#{instrumentService}")
    private InstrumentService instrumentService;
    private Instrument instrument;
    private Long singerId;

    @PostConstruct
    private void postConstruct() {
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        instrument = params.containsKey("instrument_id") ? instrumentService.
                findById(params.get("instrument_id")) : new Instrument();
    }

    public void save() {
        instrumentService.save(instrument);
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("./index.xhtml");
        } catch (Exception e) {
        }
    }

    public void delete() {
        instrumentService.delete(instrument);
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("./index.xhtml");
        } catch (Exception e) {
        }
    }

    public void agregarSinger() {
        Singer singerFound = singerService.findById(singerId);
        if (!singerFound.getInstruments().contains(instrument)) {
            singerFound.addInstrument(instrument);
            singerService.save(singerFound);
        }
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("./index.xhtml");
        } catch (Exception e) {
        }

    }

    public SingerService getSingerService() {
        return singerService;
    }

    public void setSingerService(SingerService singerService) {
        this.singerService = singerService;
    }

    public InstrumentService getInstrumentService() {
        return instrumentService;
    }

    public void setInstrumentService(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Long getSingerId() {
        return singerId;
    }

    public void setSingerId(Long singerId) {
        this.singerId = singerId;
    }

    public List<Singer> getSingers() {
        return singerService.findByInstrumentId(instrument.getInstrumentId());
    }

}
