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
