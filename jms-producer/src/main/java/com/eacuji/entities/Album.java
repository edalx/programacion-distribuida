package com.eacuji.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by eacuji on 25/12/2017.
 */

public class Album implements Serializable {

    private Long id;
    private String title;
    private Date releaseDate;
    private int version;
    private Singer singer;

    public Long getId() {
        return this.id;
    }

    public int getVersion() {
        return version;
    }

    public Singer getSinger() {
        return this.singer;
    }

    public String getTitle() {
        return this.title;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Album - Id: " + id + ", Singer id: " + singer.getId()
                + ", Title: " + title + ", Release Date: " + releaseDate;
    }
}
