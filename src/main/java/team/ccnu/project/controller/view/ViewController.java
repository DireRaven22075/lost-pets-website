package team.ccnu.project.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class ViewController {
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
    ///</summary>
    @GetMapping
    public ModelAndView index(HttpServletRequest request, Model model) {
        ModelAndView mav = buildModelAndView(request, "view/index");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 로그인 화면 출력 함수
    ///</summary>
    @GetMapping("/login")
    public ModelAndView login(HttpServletRequest request, Model model) {
        ModelAndView mav = buildModelAndView(request, "view/login");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 회원가입 화면 출력 함수
    ///</summary>
    @GetMapping("/register")
    public ModelAndView register(HttpServletRequest request) {
        ModelAndView mav = buildModelAndView(request, "view/register");
        return mav;
    }
    /// <summary>
    /// [HTTP GET] 신고 게시판 화면 출력 함수
    /// </summary>
}