package team.ccnu.project.controller.view;

import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.view.RedirectView;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.service.CommentService;
import team.ccnu.project.service.ImageService;
import team.ccnu.project.service.PostService;
import team.ccnu.project.service.UserService;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/")
public class ViewController {
    @Autowired
    private PostService posts;
    @Autowired
    private UserService users;
    @Autowired
    private CommentService comments;
    @Autowired
    private ImageService images;
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
    /// [HTTP GET] 게시판 출력 함수
    /// </summary>
    @GetMapping("/boards/0")
    public ModelAndView viewAdopt(
            HttpServletRequest request
    ) {
        ModelAndView mav = buildModelAndView(request, "view/board");
        mav.addObject("title", "Adopt");
        mav.addObject("description", "작고 연약한 아이가 받은 상처가 아물 수 있도록");
        mav.addObject("explain", "입양하고 싶은 유실 동물에 대해 자세하게 작성해 주세요");
        mav.addObject("bbs", 0L);
        List<Post> post = posts.findAll(0L);
        Collections.reverse(post);
        mav.addObject("posts", post);
        return mav;
    }
    /// <summary>
    /// [HTTP GET] 게시판 출력 함수
    /// </summary>
    @GetMapping("/boards/1")
    public ModelAndView viewReport(
            HttpServletRequest request
    ) {
        ModelAndView mav = buildModelAndView(request, "view/board");
        mav.addObject("title", "Report");
        mav.addObject("description", "작고 연약한 생명이 상처 받는 일이 없길");
        mav.addObject("explain", "신고할 유실 동물의 외형과 위치를 알려주세요");
        mav.addObject("bbs", 1L);
        List<Post> post = posts.findAll(1L);
        Collections.reverse(post);
        mav.addObject("posts", post);
        return mav;
    }
    /// <summary>
    /// [HTTP GET] 게시판 출력 함수
    /// </summary>
    @GetMapping("/boards/2")
    public ModelAndView viewEducation(
            HttpServletRequest request
    ) {
        ModelAndView mav = buildModelAndView(request, "view/board");
        mav.addObject("title", "Education");
        mav.addObject("description","생명을 기르기 위한 위대한 한 걸음");
        mav.addObject("explain", "모든 반려 동물을 위해 공유하고 싶은 정보를 자유롭게 작성하세요");
        mav.addObject("bbs", 2L);
        List<Post> post = posts.findAll(2L);
        Collections.reverse(post);
        mav.addObject("posts", post);
        return mav;
    }

    @GetMapping("/post/{pst}")
    public ModelAndView viewPost(
            @PathVariable Long pst,
            HttpServletRequest request

    ) {
        ModelAndView mav = buildModelAndView(request,"view/post");
        Post post = posts.getPostBySn(pst);
        if (post == null) {
            return new ModelAndView(new RedirectView("/error"));
        }
        post.setView(post.getView() + 1);
        posts.save(post);
        switch (post.getUid().intValue()) {
            case 0: //Adopt
                mav.addObject("title", "입양게시판");
                break;
            case 1: //Report
                mav.addObject("title", "신고게시판");
                break;
            case 2:
                mav.addObject("title", "교육게시판");
                break;
        }
        mav.addObject("post", post);
        return mav;
    }
}