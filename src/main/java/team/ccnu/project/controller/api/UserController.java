package team.ccnu.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import team.ccnu.project.domain.entity.MemberEntity;
import team.ccnu.project.service.MemberService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private MemberService memberService;

    /// <summary>
    /// TODO : 구현 필요
    /// 회원가입 처리
    /// METHOD : POST
    /// RETURN : Json
    /// URL : /api/users
    /// </summary>
    @PostMapping
    public ResponseEntity<?> signUpUser(
            @RequestParam String id,
            @RequestParam String pw,
            @RequestParam String name,
            @RequestParam String email
    ) {
        HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(new URL("http://localhost:8080/api/users"));
        if (memberService.findById(id) != null) {
            headers.add("data", "{ \"message\": \"ID already exists\" }");
        }
        else if (memberService.findByEmail(email) != null) {
            headers.add("data", "{ \"message\": \"Email already exists\" }");
        }
        else {
            MemberEntity member = memberService.addUser(id, pw, name, email);
            if (member != null) {
                headers.add("data", "{ \"message\": \"success\" }");
            }
            else {
                headers.add("data", "{ \"message\": \"fail\" }");
            }
        }
        return new ResponseEntity<>(headers, HttpStatus.PERMANENT_REDIRECT);
    }

    /// <summary>
    /// TODO : 구현 필요
    /// 회원탈퇴 처리
    /// METHOD : DELETE
    /// RETURN : Json
    /// URL : /api/users/{id}
    /// </summary>
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        return ResponseEntity.ok("success");
    }

    /// <summary>
    /// TODO : 구현 필요
    /// 회원 정보 수정
    /// METHOD : PUT
    /// RETURN : Json
    /// URL : /api/users/{id}
    /// </summary>
    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id) {
        return "success";
    }

}
