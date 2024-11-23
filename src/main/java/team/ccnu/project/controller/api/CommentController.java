package team.ccnu.project.controller.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards/{boardId}/posts/{postId}/comments")
public class CommentController {
    @GetMapping("")
    public String getAll() {
        return "success";
    }
    @PostMapping("")
    public String add() {
        return "success";
    }
    @GetMapping("/{commentId}")
    public String get(@PathVariable String commentId) {
        return "success";
    }
    @PutMapping("/{commentId}")
    public String update(@PathVariable String commentId) {
        return "success";
    }
    @DeleteMapping("/{commentId}")
    public String delete(@PathVariable String commentId) {
        return "success";
    }
}

//// To Do //////
// 예외처리: 각 메서드에 다양한 예외처리 해주기
// 응답 형식 통일성 부족: 모든 메서드가 단순히 "success"라는 문자열을 반환. 실제 데이터나 상태 코드를 포함한 ResponseEntity를 사용하여 더 의미 있는 응답을 제공해야 함
// 메서드 구현 미완성: 각 메서드의 실제 로직이 구현X. 데이터 베이스 연동 or 비즈니스 로직 추가해야 함.