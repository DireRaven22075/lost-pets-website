package team.ccnu.project.controller;

/*
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
     */