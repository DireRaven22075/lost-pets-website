package team.ccnu.project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//*
@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        // Customize your error message
        ModelAndView mav = new ModelAndView("__TEST__/error");
        String originalUrl = (String) request.getAttribute("javax.servlet.error.request_uri");
        mav.addObject("url", originalUrl);
        int code = Integer.valueOf(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString());
        mav.addObject("code", code);

        return mav;
    }
}
//*/
