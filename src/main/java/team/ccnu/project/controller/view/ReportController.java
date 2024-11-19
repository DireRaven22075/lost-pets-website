package team.ccnu.project.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import team.ccnu.project.service.UserService;

@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ModelAndView viewList(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("view/board");
        return modelAndView;
    }
}
