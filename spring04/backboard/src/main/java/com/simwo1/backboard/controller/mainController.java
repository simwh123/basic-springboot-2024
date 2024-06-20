package com.simwo1.backboard.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class mainController {

    @GetMapping("/hello")
    public String hello() {
        log.info("getHello(); 실행.");
        return "hello";
    }

    @GetMapping("/")
    public String main() {
        return "redirect:/board/list"; // localhost:8080/ -> localhost:8080/board/list 변경
    }
}
