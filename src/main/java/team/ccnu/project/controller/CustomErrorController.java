package team.ccnu.project.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        // Customize your error message
        ModelAndView mav = new ModelAndView("__TEST__/error");
        int code = Integer.valueOf(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString());
        switch (code) {
            case 403: //Forbidden
                mav.addObject("error.title", "403 - FORBIDDEN");
                mav.addObject("error.subTitle", "");
                mav.addObject("error.description", "");
                break;
            case 404: //Not FOUND
                mav.addObject("error.description", "");
                mav.addObject("text", "NOT_FOUND");
                break;

        }
        mav.addObject("code", code);

        return mav;
    }
}