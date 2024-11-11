package team.ccnu.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import team.ccnu.project.domain.entity.MemberEntity;
import team.ccnu.project.service.MemberService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @GetMapping("/logout")
    public String getMethodName(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
    
    @Autowired
    private MemberService memberService;
    /// <summary>
    /// TODO : 구현 필요
    /// <br/> 로그인 처리 <br/>
    /// METHOD : POST
    /// RETURN : Json-Session
    /// URL : /api/auth/login
    /// </summary>
    @PostMapping("/login")
    public String login(HttpServletRequest request, @RequestParam String id, @RequestParam String pw) {
        //TEST : 
        if (id.equals("admin") && pw.equals("admin")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("id", id);
            return "{status: 'success', message: '로그인 성공'}";
        }
        MemberEntity member = memberService.findById(id);
        if (member == null) {
            return "{status: 'fail', message: '아이디가 존재하지 않습니다.'}";
        }
        if (!member.getPw().equals(pw)) {
            return "{status: 'fail', message: '비밀번호가 일치하지 않습니다.'}";
        }
        // 세션에 계정 정보 저장
        
        return "{status: 'success', message: '로그인 성공'}";
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
