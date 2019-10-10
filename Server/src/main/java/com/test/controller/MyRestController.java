package com.test.controller;

import com.test.datamode.UrlMapping;
import com.test.datamode.UrlRepository;
import com.test.service.KeyManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@RestController
@RequestMapping(value = "/url")
public class MyRestController {

    @Autowired
    UrlRepository urlRepository;

    //@GetMapping(value = "/create")
    public ResponseEntity <String> getUrl(String url){
        System.out.println("Input Url:" +url);
        String shortUrl="TestUrl";
        return new ResponseEntity(shortUrl, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity <String> createShortUrl(String url){
        System.out.println("Input Url:" +url);

        //Check if valid URL

        String key = KeyManagementService.getNewKey();
        UrlMapping urlMapping = new UrlMapping(1l, url, key);
        urlRepository.save(urlMapping);

        String shortUrl="localhost:8080/"+key;
        return new ResponseEntity(shortUrl, HttpStatus.OK);
    }
}
