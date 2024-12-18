package team.ccnu.project.controller.view.board;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import team.ccnu.project.data.response.PostDTO;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.service.PostService;

import java.util.LinkedList;

@Controller
@RequestMapping("/adopt")
public class AdoptBoardController {
    @Autowired
    private PostService posts;
    private ModelAndView buildModelAndView(HttpServletRequest request, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("user", request.getSession(true).getAttribute("user"));
        return mav;
    }

    @GetMapping
    public ModelAndView viewList(
            HttpServletRequest request
    ) {
        ModelAndView mav = buildModelAndView(request, "view/board");
        mav.addObject("title", "Adopt");
        mav.addObject("description", "작고 연약한 아이가 받은 상처가 아물 수 있도록");
        mav.addObject("explain", "입양하고 싶은 유실 동물에 대해 자세하게 작성해 주세요");
        mav.addObject("bbs", 0L);
        mav.addObject("posts", new LinkedList<PostDTO>().add(new PostDTO()));
        return mav;
    }
    @GetMapping("/post/{pst}")
    public ModelAndView viewPost(@PathVariable Long pst) {
        ModelAndView mav = new ModelAndView("view/post");
        Post post = posts.getPostBySn(pst);
        if (post == null) {
            return new ModelAndView(new RedirectView("/error"));
        }
        post.setView(post.getView() + 1);
        posts.save(post);
        mav.addObject("post", post);
        mav.addObject("title", "입양 게시판");
        mav.addObject("description", "작고 연약한 아이가 받은 상처가 아물 수 있도록");
        mav.addObject("explain", "입양하고 싶은 유실 동물에 대해 자세하게 작성해 주세요");
        mav.addObject("posts", new LinkedList<PostDTO>().add(new PostDTO()));
        mav.addObject("bbs", 0L);
        return mav;
    }
}
