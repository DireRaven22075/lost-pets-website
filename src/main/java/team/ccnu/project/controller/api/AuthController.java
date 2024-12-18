package team.ccnu.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import team.ccnu.project.data.request.LogInDTO;
import team.ccnu.project.data.response.UserDTO;
import team.ccnu.project.domain.entity.User;
import team.ccnu.project.service.UserService;

@Controller
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    /// <summary>
    /// <br/> 로그인 처리 <br/>
    /// METHOD : POST
    /// RETURN : Json-Session
    /// URL : /api/auth/login
    /// </summary>
    @PostMapping("/login")
    public ResponseEntity<?> apiAuthLogin(HttpServletRequest request, @RequestBody LogInDTO dto) {
        try {
            if (!userService.isExistID(dto.getId()) || !userService.equalsPW(dto)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("""
                {"status": "error", "code": 404, "message" : "아이디 혹은 비밀번호가 일치하지 않습니다."}
                """);
            }
            User user = userService.login(dto);
            UserDTO response = new UserDTO(user);
            HttpSession session = request.getSession(true);
            session.setAttribute("user", response);
            session.setAttribute("token", user.getSn());
            return ResponseEntity.ok().body(
                    String
                            .format("""
                                {"status": "success", "code": 200, "message": "%s님 환영합니다."}""",
                                    response.getName()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
            {"status": "error", "code": 500, "message": "잠시후 다시 시도해주십시오."}
            """);
        }
    }

    /// <summary>
    /// DONE : 구현 완료
    /// <br/> 로그아웃 처리 <br/>
    /// DELETE, Json, /api/auth/Logout
    /// </summary>
    @DeleteMapping("/logout")
    public ResponseEntity<?> apiAuthLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("""
            {"status": "error", "code": 403, "message": "이미 로그아웃 상태입니다."}
            """);
        }
        try {
            session.invalidate();
            return ResponseEntity.status(HttpStatus.OK).body("""
            {"status": "success", "code": 200, "message": "로그아웃 되었습니다."}
            """);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
            {"status": "error", "code": 500, "message": "잠시후 다시 시도해주십시오"}
            """);
        }
    }
}
