package com.example.test.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller @RestController
public class AccountsController {
    @Autowired
    AccountsServiceImp service;

    @GetMapping("/accounts/sign")
    public String sign(Model model) {
        return "accounts/sign";
    }
    @GetMapping("/accounts/forgot-password")
    public String forgotPassword(Model model) {
        return "accounts/forgot-password";
    }
    @GetMapping("/accounts/reset-password")
    public String resetPassword(Model model) {
        return "accounts/reset-password";
    }
    @GetMapping("/accounts/confirm-mail")
    public String confirmMail(@RequestParam Long id) {
        return "accounts/confirm-mail";
    }
}
