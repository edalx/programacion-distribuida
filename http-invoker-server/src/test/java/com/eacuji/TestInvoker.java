package com.eacuji;

import com.eacuji.entities.Album;
import com.eacuji.entities.Instrument;
import com.eacuji.entities.Singer;
import com.eacuji.services.AlbumService;
import com.eacuji.services.InstrumentService;
import com.eacuji.services.SingerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestInvoker {
    private Logger logger = LoggerFactory.getLogger(TestInvoker.class);
    @Autowired
    private SingerService singerService;
    @Autowired
    private InstrumentService instrumentService;
    @Autowired
    private AlbumService albumService;

    @Test
    public void testRmiAll() {
        List<Singer> singers = singerService.findAll();
        Assert.assertEquals(3, singers.size());
        listSingers(singers);
    }

    @Test
    public void testRmiJohn() {
        logger.info("Test singer 1");
        Singer singers1 = singerService.findById(1l);
        logger.info(singers1.toString());
        logger.info(singers1.getAlbums().toString());
        logger.info(singers1.getInstruments().toString());
        logger.info("Test singer 2");
        Singer singers2 = singerService.findById(2l);
        logger.info(singers2.toString());
        logger.info(singers2.getAlbums().toString());
        logger.info(singers2.getInstruments().toString());
        logger.info("Test singer 3");
        Singer singers3 = singerService.findById(3l);
        logger.info(singers3.toString());
        logger.info(singers3.getAlbums().toString());
        logger.info(singers3.getInstruments().toString());

    }

    @Test
    public void testInstrument() {
        List<Instrument> instruments = instrumentService.findAll();
        logger.info("Existen " + instruments.size());
        logger.info("Los instrumentos son: ");
        logger.info(instruments.toString());
        Assert.assertEquals(5, instruments.size());
    }

    @Test
    public void testAlbum() {
        List<Album> albums = albumService.findAll();
        logger.info("Existen " + albums.size());
        logger.info("Los albums son: ");
        logger.info(albums.toString());
        Assert.assertEquals(3, albums.size());
    }

    @Test
    public void testAlbumById() {
        Album album = albumService.findById(1l);
        logger.info(album.toString());
        Album album1 = albumService.findById(2l);
        logger.info(album1.toString());
        Album album2 = albumService.findById(3l);
        logger.info(album2.toString());
    }

    @Test
    public void testSingers() {
        List<Instrument> singers = instrumentService.findSingerId(1l);
        List<Album> albums = albumService.findSingerId(1l);
        logger.info("Probando los servicios");
        logger.info(singers.toString());
        logger.info(albums.toString());
    }

    private void listSingers(List<Singer> singers) {
        singers.forEach(s -> logger.info(s.toString()));
    }
}

