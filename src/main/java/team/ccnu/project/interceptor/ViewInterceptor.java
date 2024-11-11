package team.ccnu.project.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class ViewInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(1800);
        // 세션이 없으면 /login으로 리다이렉트
        if (session.isNew() == true) {
            return false;
        }
        return true; // 세션이 있으면 계속 진행
    }
}