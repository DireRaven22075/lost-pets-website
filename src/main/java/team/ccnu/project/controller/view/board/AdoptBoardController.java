package team.ccnu.project.controller.view.board;

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

@Controller
@RequestMapping("/adopt")
public class AdoptBoardController {
    @Autowired
    private PostService posts;

    @GetMapping("/{index}")
    public ModelAndView viewList(@PathVariable int index) {
        ModelAndView mav = new ModelAndView("board");
        mav.addObject("posts", posts.getPostsByPageByIndex(0L, index));
        return mav;
    }
    @GetMapping("/post/{pst}")
    public ModelAndView viewPost(@PathVariable Long pst) {
        ModelAndView mav = new ModelAndView("post");
        Post post = posts.getPostBySn(pst);
        if (post == null) {
            return new ModelAndView(new RedirectView("/error"));
        }
        mav.addObject("post", new PostDTO(post));
        return mav;
    }
    @GetMapping("/write")
    public ModelAndView viewWrite() {
        ModelAndView mav = new ModelAndView("write");
        mav.addObject("bbs", 0L);
        return mav;
    }
}
