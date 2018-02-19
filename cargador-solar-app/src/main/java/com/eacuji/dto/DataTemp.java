package com.eacuji.dto;

/**
 * Created by eacuji on 19/02/2018.
 */
public class DataTemp {
    private String dato;

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "DataTemp{" +
                "dato='" + dato + '\'' +
                '}';
    }
}
