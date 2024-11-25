package team.ccnu.project.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.domain.entity.User;
//import team.ccnu.project.service.PostService;

@Component
public class WriteInterceptor implements HandlerInterceptor {

//    @Autowired
//    private PostService postService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        
        // 세션이 없는 경우
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/login");
            return false;
        }

        User user = (User) session.getAttribute("user");
        
        // URL에서 postId 추출
        String postId = extractPostIdFromUrl(request.getRequestURI());
        
        // 새 글 작성의 경우
        if (postId == null) {
            return true; // 로그인한 사용자는 새 글 작성 가능
        }

        // 기존 글 수정의 경우
        try {
            Post post = new Post();
            if (post == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Post not found");
                return false;
            }

            if (user.getSn() != post.getOwner().getSn()) {
                response.sendRedirect("/");
                return false;
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid post ID");
            return false;
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing request");
            return false;
        }

        return true;
    }

    private String extractPostIdFromUrl(String url) {
        String[] parts = url.split("/");
        return parts.length > 2 ? parts[parts.length - 1] : null;
    }
}

//// To Do //////
// 세션 관리 로직 개선: 현재 코드는 세션이 새로 생성 => 로그인 페이지로 무조건 리다이렉션. 이를 좀 더 정교하게 수정. 세션 관리 로직
// 권한 체크 미구현: '새로운 세션이면 true 리턴X', '로그인 안됐는데 게시물 작성하면 false 리턴' 기능 구현 

// 현재 1차 수정 ToDo내용 구현. 세션이 없거나 사용자 정보 없는 경우 체크/ URL에서 postId를 추출하는 메소드를 추가하여 새 글 작성과 기존 글 수정 구분 / PostService를 주입받아 실제 포스트 정보 조회 / 포스트 작성자와 현재 사용자의 sn을 비교하여 권한 체크 / 다양한 예외 상황(포스트 X, 잘못된 postid 등)에 대한 처리를 추가