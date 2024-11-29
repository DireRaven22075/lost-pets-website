package team.ccnu.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    /// FIXME : MYSQL 연동 필요..
    /// <br/> 로그인 처리 <br/>
    /// METHOD : POST
    /// RETURN : Json-Session
    /// URL : /api/auth/login
    /// </summary>
    @PostMapping("/login")
    public ResponseEntity<?> apiAuthLogin(HttpServletRequest request, @RequestBody LogInDTO dto) {
        try {
            if (!userService.isExistID(dto.getId())) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("""
                {"status": "error", "message" : "Id not found"}
                """);
            }
            if (!userService.equalsPW(dto)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("""
                {"status": "error", "message" : "Password incorrect"}
                """);
            }
            User user = userService.login(dto);
            UserDTO response = new UserDTO(user);
            HttpSession session = request.getSession(true);
            session.setAttribute("user", response);
            return ResponseEntity.ok().body("""
            {"status": "success", "message": "login successful"}
            """);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
            {"status": "error", "message": "internal server error"}   
            """);
        }
    }

    /// <summary>
    /// DONE : 구현 완료
    /// <br/> 로그아웃 처리 <br/>
    /// DELETE, Json, /api/auth/DELETELogout
    /// </summary>
    @DeleteMapping("/logout")
    public ResponseEntity<?> apiAuthLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("""
            {"status": "error", "message": "unauthorized"}
            """);
        }
        try {
            session.invalidate();
            return ResponseEntity.status(HttpStatus.OK).body("""
            {"status": "success", "message": "DELETELogout successful"}
            """);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
            {"status": "error", "message": "internal server error"}   
            """);
        }
    }
}
