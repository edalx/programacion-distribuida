package com.eacuji.config;


import com.eacuji.entities.Singer;
import com.eacuji.services.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by eacuji on 07/01/18.
 */
@SuppressWarnings("unchecked")
@Service
public class DBInitializer {
    private Logger logger = LoggerFactory.getLogger(DBInitializer.class);

    @Autowired
    SingerService singerDao;

    @PostConstruct
    public void initDB() {
        logger.info("Starting database initialization...");

        Singer singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1977, 9, 16)).getTime().getTime()));

        singerDao.save(singer);

        singer = new Singer();
        singer.setFirstName("Eric");
        singer.setLastName("Clapton");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1945, 2, 30)).getTime().getTime()));
        singerDao.save(singer);

        singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Butler");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1975, 3, 1)).getTime().getTime()));
        singerDao.save(singer);
        logger.info("Database initialization finished.");
    }

}
