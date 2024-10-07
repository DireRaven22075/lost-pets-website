package com.example.week5;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController

public class HelloController {
    
    @GetMapping("/Hello")

    public String hello() {
        return "Hello World!";
    }
}
