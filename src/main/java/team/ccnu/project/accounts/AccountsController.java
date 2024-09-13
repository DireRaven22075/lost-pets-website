package team.ccnu.project.accounts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller @RequestMapping("/accounts")
public class AccountsController {
    //#region View Mapping
    @RequestMapping(path="/", method=RequestMethod.GET)
    public String viewMain(Model model) {
        return "view/accounts";
    }
    @GetMapping("/forgot-password")
    public String viewForgotPW(Model model) {
        return "view/accounts-forgot-password";
    }
    @GetMapping("/list/{id}/{index}")
    @ResponseBody
    public String c() {

        return "";
    }
    //#endregion

    //#region Rest Mapping
    @PostMapping("/check") @ResponseBody
    public String requestCheck(@RequestBody String entity) {
        //post 요청이 아닌 일반적 요청을 받을 경우
        if (entity == null) {
            //accounts url로 보내버림
            return "redirect:/accounts/";
        }
        //TODO: process POST request
        
        return entity;
    }
    //#endregion
}
