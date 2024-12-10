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
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping
    public ModelAndView index(HttpServletRequest request, Model model) {
        ModelAndView mav = buildModelAndView(request, "index");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 로그인 화면 출력 함수
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping("/login")
    public ModelAndView login(HttpServletRequest request, Model model) {
        ModelAndView mav = buildModelAndView(request, "login");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 회원가입 화면 출력 함수
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping("/register")
    public ModelAndView register(HttpServletRequest request) {
        ModelAndView mav = buildModelAndView(request,"makeaccount");
        return mav;
    }
    ///<summary>
    /// [HTTP GET] 회원가입 화면 출력 함수
    /// TODO : 구현 필요
    ///</summary>
    @GetMapping("/post")
    public ModelAndView testPost(HttpServletRequest request) {
        ModelAndView mav = buildModelAndView(request,"post");
        return mav;
    }
   ///<summary>
   /// [HTTP GET] 비밀번호 찾기 화면 출력 함수
   /// TODO : 구현 필요
   ///</summary>
   @GetMapping("/forgot-password")
   public ModelAndView forgotPassword(HttpServletRequest request) {
       ModelAndView mav = buildModelAndView(request,"/forgot-password");
       return mav;
   }
   ///<summary>
   /// [HTTP GET] 회원 정보 화면 출력 함수
   /// TODO : 구현 필요
   ///</summary>
   @GetMapping("/ami")
   public ModelAndView ami(HttpServletRequest request) {
       ModelAndView mav = buildModelAndView(request, "/userinfo");
       return mav;
   }
   ///<summary>
   /// [HTTP GET] 게시판 화면 출력 함수
   /// TODO : 구현 필요
   ///</summary>
   @GetMapping("/education")
   public ModelAndView education(HttpServletRequest request) {
       ModelAndView mav = buildModelAndView(request, "/education");
       return mav;
   }
   @GetMapping("/adopt")
   public ModelAndView adopt(HttpServletRequest request) {
       ModelAndView mav = buildModelAndView(request, "/adopt");
       return mav;
   }
   @GetMapping("/report")
   public ModelAndView report(HttpServletRequest request) {
       ModelAndView mav = buildModelAndView(request, "/report");
       return mav;
   }
   /// <summary>
   /// [HTTP GET] 게시글 화면 출력 함수
   /// TODO : 구현 필요
   /// </summary>
   @GetMapping("/post/{id}/{sn}")
   public ModelAndView post(HttpServletRequest request, @PathVariable String id, @PathVariable String sn) {
       ModelAndView mav = buildModelAndView(request, "/board");
       return mav;
   }
   ///<summary>
   /// [HTTP GET] 게시글 작성 화면 출력 함수
   /// TODO : 구현 필요
   ///</summary>
   @GetMapping("/write/{id}")
   public ModelAndView write(HttpServletRequest request, @PathVariable String id) {
       ModelAndView mav = buildModelAndView(request, "/write");
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