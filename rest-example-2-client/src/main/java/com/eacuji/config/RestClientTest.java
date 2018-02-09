package com.eacuji.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
/**
 * Created by eacuji on 29/01/2018.
 */
public class RestClientTest {
    final Logger logger =
            LoggerFactory.getLogger(RestClientTest.class);
    private static final String URL_GET_ALL_SINGERS =
            "http://localhost:8080/singer/listdata";

}
