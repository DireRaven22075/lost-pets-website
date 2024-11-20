package team.ccnu.project.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class WriteInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(1800);
        if (session.isNew()) {
            response.sendRedirect("/login");
            response.addHeader("Access-Control-Allow-Origin", "*");
            return false;
        }
        // 세션이 없으면 /login으로 리다이렉트
        return true; // 세션이 있으면 계속 진행
    }
}