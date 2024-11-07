package team.ccnu.project.controller.api;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    /// <summary>
    /// TODO : 구현 필요
    /// 회원가입 처리
    /// METHOD : POST
    /// RETURN : Json
    /// URL : /api/users
    /// </summary>
    @PostMapping
    public String signUpUser() {

        return "success";
    }
    /// <summary>
    /// TODO : 구현 필요
    /// 회원탈퇴 처리
    /// METHOD : DELETE
    /// RETURN : Json
    /// URL : /api/users/{id}
    /// </summary>
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        return "success";
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