package com.eacuji;

import com.eacuji.dto.Singer;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by eacuji on 29/01/2018.
 */
public class RestClientTest {
    final Logger logger =
            LoggerFactory.getLogger(RestClientTest.class);
    private static final String URL_GET_ALL_SINGERS = "http://localhost:8080/singer";
    RestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void testFindAll() {
        logger.info("--> Testing retrieve all singers");
        Singer s1=new Singer();
        s1.setFirstName("Alexander");
        s1.setLastName("Cuji");
        s1.setBirthDate(new Date(
                (new GregorianCalendar(1993, 9, 10)).getTime().getTime()));
        HttpEntity<Singer> request = new HttpEntity<>(s1);
        restTemplate.postForObject("http://localhost:8080/singer", request, Singer.class);
    }


}
