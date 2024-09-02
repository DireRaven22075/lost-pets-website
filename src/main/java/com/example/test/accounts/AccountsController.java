package com.example.test.accounts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AccountsController {
    @GetMapping("/accounts/sign")
    public String sign(Model model) {
        return "accounts/sign";
    }
    
}
