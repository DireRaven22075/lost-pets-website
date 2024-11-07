package team.ccnu.project.controller.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    /// <summary>
    /// TODO : 구현 필요
    /// <br/> 로그인 처리 <br/>
    /// POST, Json-Session, /api/auth/login
    /// </summary>
    @PostMapping("/login")
    public String login() {
        
        return "success";
    }
    /// <summary>
    /// TODO : 구현 필요
    /// <br/> 로그아웃 처리 <br/>
    /// DELETE, Json, /api/auth/logout
    /// </summary>
    @DeleteMapping("/logout")
    public String logout() {
        return "success";
    }
    /// <summary>
    /// TODO : 구현 필요
    /// <br/>비밀번호 찾기 요청 처리<br/>
    /// POST, Json, /api/auth/password/reset-request
    /// </summary>
    @PostMapping("/password/reset-request")
    public String requestPasswordReset(@RequestParam String email) {
        return "success";
    }
    /// <summary>
    /// TODO : 구현 필요
    /// 비밀번호 업데이트 처리
    /// METHOD : PUT
    /// RETURN : JSON
    /// URL : /api/auth/password/reset
    /// </summary>
    @PutMapping("/password/reset")
    public String resetPassword(@RequestParam String email) {
        return "success";
    }
}
