package com.test.controller;

import com.test.datamode.UrlMapping;
import com.test.datamode.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.remoting.soap.SoapFaultException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @Autowired
    UrlRepository urlRepository;

//    @RequestMapping("/")
//    public String index() {
//        return "Greetings from Spring Boot!";
//    }

    @RequestMapping("/*")
    public String processForm(HttpServletRequest request)
    {
        String path = request.getPathInfo();
        System.out.println(request.getRequestURL());
        System.out.println(path);
        //String redirectUrl = request.getScheme() + "://www.yahoo.com";
        String redirectUrl = getUrl(request.getRequestURI().substring(1));
        return "redirect:" + redirectUrl;
    }

    private String getUrl(String key){
        System.out.println(urlRepository.findAll());

        UrlMapping mapping = urlRepository.findByKey(key);
        System.out.println(mapping.getUrl());
        return mapping.getUrl();
    }
}
