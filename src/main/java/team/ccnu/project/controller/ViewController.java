package team.ccnu.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import team.ccnu.project.Constants;
@Controller
@RequestMapping("/")
public class ViewController {
    ///<summary>
    /// [HTTP GET] 메인 화면 출력 함수
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping()
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView(Constants.TestURL + "/index");
        System.out.println(mav.getViewName());
        mav.addObject("name", "AHA");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 로그인 화면 출력 함수
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping("/login")
    public ModelAndView login(Model model) {
        ModelAndView mav = new ModelAndView(Constants.TestURL + "/login");
        mav.addObject("name", "AHA");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 회원가입 화면 출력 함수
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping("/register")
    public ModelAndView register(Model model) {
        ModelAndView mav = new ModelAndView(Constants.TestURL + "/register");
        mav.addObject("name", "AHA");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 비밀번호 착기 화면 출력 함수
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping("/forgot-password")
    public ModelAndView forgotPassword(Model model) {
        ModelAndView mav = new ModelAndView(Constants.TestURL + "/forgot-password");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 회원 정보 화면 출력 함수
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping("/ami")
    public ModelAndView ami(Model model) {
        ModelAndView mav = new ModelAndView(Constants.TestURL + "/ami");
        mav.addObject("name", "AHA");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 게시판 화면 출력 함수
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping("/board/{id}/{index}")
    public ModelAndView board(Model model, @PathVariable String id, @PathVariable String index) {
        ModelAndView mav = new ModelAndView(Constants.TestURL + "/board");

        return mav;
    }
    /// <summary>
    /// [HTTP GET] 게시글 화면 출력 함수
    /// TODO : 구현 필요
    /// </summary>
    @GetMapping("/post/{id}/{sn}")
    public ModelAndView post(Model model, @PathVariable String id, @PathVariable String sn) {
        ModelAndView mav = new ModelAndView(Constants.TestURL + "/post");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 게시글 작성 화면 출력 함수
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping("/write/{id}")
    public ModelAndView write(Model model, @PathVariable String id) {
        ModelAndView mav = new ModelAndView(Constants.TestURL + "/write");
        mav.addObject("name", "AHA");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 게시글
    ///</summary>
    @GetMapping("/modify/{id}/{uid}")
    public ModelAndView modify(Model model, @PathVariable String id, @PathVariable String uid) {
        ModelAndView mav = new ModelAndView(Constants.TestURL + "/modify");
        return mav;
    }
}