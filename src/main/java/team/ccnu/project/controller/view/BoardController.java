package team.ccnu.project.controller.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/{bbs}")
public class BoardController {
    @GetMapping("/{index}")
    public ModelAndView viewList(
            HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable String bbs,
            @PathVariable Long index) {
        Long boardId = -1L;
        switch (bbs) {
            case "adopt": boardId = 0L; break;
            case "report": boardId = 1L; break;
            case "education": boardId = 2L; break;
            default:
                return new ModelAndView("redirect:/error/404");
        }
        ModelAndView mav = new ModelAndView("board");

        return mav;
    }
}
