package com.eacuji.dto;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer usbId;

    private String estado;

    private Long duracion;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUsbId() {
        return usbId;
    }

    public void setUsbId(Integer usbId) {
        this.usbId = usbId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getDuracion() {
        return duracion;
    }

    public void setDuracion(Long duracion) {
        this.duracion = duracion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", usbId='" + usbId + '\'' +
                ", estado='" + estado + '\'' +
                ", duracion=" + duracion +
                ", createdAt=" + createdAt +
                '}';
    }
}
