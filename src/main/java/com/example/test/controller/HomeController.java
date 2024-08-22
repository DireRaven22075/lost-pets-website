package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class HomeController {
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("message", "이히히");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About");
        model.addAttribute("message", "이히히");
        return "about";
    }

    @PostMapping("/path")
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
}