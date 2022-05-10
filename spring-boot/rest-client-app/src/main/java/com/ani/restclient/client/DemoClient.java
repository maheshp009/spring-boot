package com.ani.restclient.client;

import com.ani.restclient.dto.AppResCl;
import com.ani.restclient.dto.MobileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DemoClient {

    @Autowired
    private RestTemplate restTemplate;


    public void showMobileV2() {
        ResponseEntity<List<MobileDto>> entity = restTemplate.exchange( // you are making rest call
                "http://localhost:8989/mobile/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() { }
        );

        List<MobileDto> mobiles = entity.getBody();
        mobiles.forEach(System.out::println);
    }

    public void showMobile() {

        ResponseEntity<List> entity = restTemplate.getForEntity("http://localhost:8989/mobile/", List.class);
        List mobiles1 = entity.getBody(); // ❌
        mobiles1.forEach( mobile -> System.out.println(mobile.toString()) );

        List mobiles2 = restTemplate.getForObject("http://localhost:8989/mobile/", List.class);
        mobiles2.forEach( mobile -> System.out.println(mobile.toString()) );
    }

    public void saveMobiles() {
        // entity - getForEntity
        // object - getForObject
        // exchange -

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
//        headers.set("Content-Type", "application/xml");

        MobileDto dto = new MobileDto();
        dto.setId(78L);
        dto.setCountry("US");
        dto.setNumber("9090909090");
        dto.setIsDualSim(true);

        HttpEntity<MobileDto> httpEntity = new HttpEntity<>(dto);

        // POST, PUT, DELETE
        ResponseEntity<AppResCl> entity = restTemplate.exchange( // you are making rest call
                "http://localhost:8989/mobile/",
                HttpMethod.POST,
               httpEntity,
                AppResCl.class,
                headers
        );

        AppResCl resCl = entity.getBody();
        System.out.println(resCl.toString());
    }
}
