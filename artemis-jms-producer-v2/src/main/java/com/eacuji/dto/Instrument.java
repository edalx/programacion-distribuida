package com.eacuji.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by eacuji on 25/12/2017.
 */

public class Instrument implements Serializable {
    private String instrumentId;
    private Set<Singer> singers = new HashSet<>();

    public String getInstrumentId() {
        return this.instrumentId;
    }

    public Set<Singer> getSingers() {
        return this.singers;
    }

    public void setSingers(Set<Singer> singers) {
        this.singers = singers;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    @Override
    public String toString() {
        return "Instrument :" + getInstrumentId();
    }
}
