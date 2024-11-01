package team.ccnu.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.websocket.server.PathParam;


@Controller @RequestMapping("/")
public class ViewController {
    @GetMapping("/")
    public String viewMain() {
        return "view/main";
    }
    @GetMapping("/login")
    public String viewLogin() {
        return "view/login";
    }
    @GetMapping("/register")
    public String viewRegister() {
        return "view/register";
    }
    @GetMapping("/list/{ID}/{INDEX}")
    public String viewList(@PathParam("ID") int id, @PathParam("INDEX") int index) {
        return "view/list";
    }
    @GetMapping("/detail/{UID}")
    public String viewDetail(@PathParam("UID") int uid) {
        return "view/detail";
    }
    @GetMapping("/modify")
    public String viewModify() {
        return "view/modify";
    }
}