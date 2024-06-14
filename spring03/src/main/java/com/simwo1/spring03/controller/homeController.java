package com.simwo1.spring03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class homeController {

    @GetMapping("/")
    public String index() {
        log.info("Spring Boot Index!!");
        return "index";
    }

}
