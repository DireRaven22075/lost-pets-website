package team.ccnu.project.accounts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller @RequestMapping("/account")
public class AccountsController {
    @PostMapping("/login")
    public String postMethodName(@RequestBody String entity) {
        return entity;
    }
    @PostMapping("/register")
    public String postRegister(@RequestBody String entity) {
        return "redirect:/login";
    }
}
