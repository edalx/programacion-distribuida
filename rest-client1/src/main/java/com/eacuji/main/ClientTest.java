package com.eacuji.main;

import org.springframework.web.client.RestTemplate;


/**
 * Created by eacuji on 02/02/2018.
 */
public class ClientTest {
    private static final String URL_GET_GREETER = "http://localhost:8090/rest/greeter/hello/Alexander";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String txt=restTemplate.getForObject(URL_GET_GREETER,String.class);
        System.out.println(txt);
    }


}
