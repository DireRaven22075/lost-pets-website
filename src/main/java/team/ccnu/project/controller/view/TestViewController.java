package team.ccnu.project.controller.view;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestViewController {
    ///<summary>
    /// 시스템 개발용 함수
    ///</summary>
    private ModelAndView buildModelAndView(HttpServletRequest request, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("user", request.getSession(true).getAttribute("user"));
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 메인 화면 출력 함수
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping
    public ModelAndView index(HttpServletRequest request, Model model) {
        ModelAndView mav = buildModelAndView(request, "__test__/index");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 로그인 화면 출력 함수
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping("/login")
    public ModelAndView login(HttpServletRequest request, Model model) {
        ModelAndView mav = buildModelAndView(request, "__test__/login");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 회원가입 화면 출력 함수
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping("/register")
    public ModelAndView register(HttpServletRequest request) {
        ModelAndView mav = buildModelAndView(request,"__test__/register");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 회원가입 화면 출력 함수
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping("/post")
    public ModelAndView testPost(HttpServletRequest request) {
        ModelAndView mav = buildModelAndView(request,"__test__/post");
        return mav;
    }
    /// <summary>
    /// [HTTP GET] 게시글 화면 출력 함수
    /// TODO : 구현 필요
    /// </summary>
    @GetMapping("/comment")
    public ModelAndView post(HttpServletRequest request) {
        ModelAndView mav = buildModelAndView(request, "/__test__/board");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 게시글 작성 화면 출력 함수
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping("/write/{id}")
    public ModelAndView write(HttpServletRequest request, @PathVariable String id) {
        ModelAndView mav = buildModelAndView(request, "/board");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 게시글
    ///</summary>
    @GetMapping("/modify/{id}/{uid}")
    public ModelAndView modify(HttpServletRequest request, @PathVariable String id, @PathVariable String uid) {
        ModelAndView mav = buildModelAndView(request, "/board");
        return mav;
    }
}