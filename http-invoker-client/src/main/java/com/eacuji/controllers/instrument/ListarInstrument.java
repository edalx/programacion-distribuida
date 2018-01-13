package com.eacuji.controllers.instrument;

import com.eacuji.entities.Instrument;
import com.eacuji.services.InstrumentService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by eacuji on 25/12/2017.
 */
@ManagedBean
@ViewScoped
public class ListarInstrument implements Serializable{
    @ManagedProperty("#{instrumentService}")
    private InstrumentService instrumentService;
    private List<Instrument> instruments;

    @PostConstruct
    private void postConstruct() {
        instruments = instrumentService.findAll();
    }

    public InstrumentService getInstrumentService() {
        return instrumentService;
    }

    public void setInstrumentService(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }
}
