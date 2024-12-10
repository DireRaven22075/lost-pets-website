package team.ccnu.project.controller.view.board;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import team.ccnu.project.service.PostService;

@Controller
@RequestMapping("/report")
public class ReportBoardController {
    @Autowired
    private PostService posts;
    private ModelAndView buildModelAndView(HttpServletRequest request, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("user", request.getSession(true).getAttribute("user"));
        return mav;
    }

    @GetMapping("/{index}")
    public ModelAndView viewList(
            HttpServletRequest request,
            @PathVariable int index
    ) {
        ModelAndView mav = buildModelAndView(request, "board");
        mav.addObject("title", "Report");
        mav.addObject("description", index);
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
        mav.addObject("bbs", 1L);
        return mav;
    }
}
