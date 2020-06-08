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

    @GetMapping(value = "/create")
    public ResponseEntity<String> createShortUrlGetMapping(String url) {
        String shortUrl = createShortUrl(url);
        return new ResponseEntity(shortUrl, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createShortUrlPostMapping(String url) {
        String shortUrl = createShortUrl(url);
        return new ResponseEntity(shortUrl, HttpStatus.OK);
    }


    @GetMapping(value = "/create/{url}")
    public ResponseEntity<String> createShortUrl1(@PathVariable String url ) {
        String shortUrl = createShortUrl(url);
        return new ResponseEntity(shortUrl, HttpStatus.OK);
    }

    private String createShortUrl(String url) {
        System.out.println("Input Url:" + url);

        //Check if valid URL

        String key = KeyManagementService.getNewKey();
        UrlMapping urlMapping = new UrlMapping(1l, url, key);
        urlRepository.save(urlMapping);
        return "localhost:8080/" + key;
    }

}