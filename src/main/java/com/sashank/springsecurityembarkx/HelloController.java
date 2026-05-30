package com.sashank.springsecurityembarkx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
    @RequestMapping("/greet")
    public String hello(){
        return "hello";
    }
}
