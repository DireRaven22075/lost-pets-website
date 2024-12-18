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
@RequestMapping("/education")
public class EducationBoardController {
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
        mav.addObject("title", "Education");
        mav.addObject("description","생명을 기르기 위한 위대한 한 걸음");
        mav.addObject("explain", "모든 반려 동물을 위해 공유하고 싶은 정보를 자유롭게 작성하세요");
        mav.addObject("bbs", 2L);
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
