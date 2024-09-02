package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    
    @GetMapping("/accounts")
    public String accounts(Model model) {
        return "accounts";
    }
}
