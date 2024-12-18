package team.ccnu.project.controller.api;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import team.ccnu.project.data.request.SignUpDTO;
import team.ccnu.project.domain.entity.User;
import team.ccnu.project.service.UserService;
import team.ccnu.project.data.request.UpdateDTO;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /// <summary>
    /// TODO : Service측 구현 필요
    /// 회원 가입
    /// </summary>
    @PostMapping
    public ResponseEntity<?> apiAssignUser(HttpServletRequest request, @RequestBody SignUpDTO dto) {
        try {
            if (userService.isExistID(dto.getId())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("""
                        {"status": "error", "message": "ID is already exist"}
                        """);
            }
            if (userService.isExistEMail(dto.getMail())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("""
                        {"status": "error", "message": "E-Mail is already exist"}
                        """);
            }
            userService.signUp(dto);
            return ResponseEntity.ok().body("""
                    {"status": "success", "message": "Register Success"}
                    """);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
                    {"status": "error", "message": "Internal Server Error"}
                    """);
        }
    }

    /// <summary>
    /// TODO : Service 측 구현 필요
    /// 회원 탈퇴
    /// </summary>
    @DeleteMapping("/{mem}")
    public ResponseEntity<?> apiDeleteUser(HttpServletRequest request, @PathVariable Long mem) {
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("user") == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("""
            {"status": "error", "message": "Unauthorized Request"}
            """);
        }
        try {
            session.invalidate();
            User user = userService.findById(session.getAttribute("user.id").toString());
            user.setRole('B');
            userService.update(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
                         {"status": "error", "message": "Internal Server Error"}   
                    """);
        }
        return ResponseEntity.status(HttpStatus.OK).body("""
                    {"status": "success", "message": "Success"}   
                """);
    }

    /// <summary>
    /// 회원정보 업데이트
    /// </summary>
    @PutMapping("/{mem}")
    public ResponseEntity<?> apiUpdateUser(HttpServletRequest request,
                                           @PathVariable Long mem,
                                           @RequestBody UpdateDTO dto) {
        HttpSession session = request.getSession();
        if (session == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"status\": \"session not found\"}");
        }
        if (session.getAttribute("SN") != mem) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"status\": \"unauthorized\"}");
        }
        //TODO : 서비스 측 구현

        return ResponseEntity.ok().body("{\"status\":\"success\"}");
    }
}
