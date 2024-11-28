package team.ccnu.project.controller.view.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import team.ccnu.project.service.PostService;

@Controller
@RequestMapping("/education")
public class EducationBoardController {
    @Autowired
    private PostService posts;

    @GetMapping("/{index}")
    public ModelAndView viewList(@PathVariable int index) {
        ModelAndView mav = new ModelAndView("/board");
        mav.addObject("posts", posts.getPostsByPageByIndex(2L, index));
        return mav;
    }
    @GetMapping("/post/{pst}")
    public ModelAndView viewPost(@PathVariable Long pst) {
        ModelAndView mav = new ModelAndView("/post");
        mav.addObject("post", posts.getPostBySn(pst));
        return mav;
    }
    @GetMapping("/write")
    public ModelAndView viewWrite() {
        ModelAndView mav = new ModelAndView("/write");
        mav.addObject("bbs", 2L);
        return mav;
    }
}
