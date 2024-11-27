package team.ccnu.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.ccnu.project.domain.entity.Comment;
import team.ccnu.project.service.CommentService;

import java.util.List;

@RestController
// @RequestMapping("/api/boards/{boardId}/posts/{postId}/comments")    // 여기 이거 맞나?
@RequestMapping("/api/posts/{postSn}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments(@PathVariable Long postSn) {
        List<Comment> comments = commentService.getAllCommentsByPostSn(postSn);
        return ResponseEntity.ok(comments);
    }

    @PostMapping
    public ResponseEntity<Comment> addComment(@PathVariable Long postSn, @RequestBody Comment comment) {
        comment.getPost().setSn(postSn);
        Comment savedComment = commentService.addComment(comment);
        return ResponseEntity.ok(savedComment);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getComment(@PathVariable Long postSn) {
        return commentService.getCommentBySn(postSn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long postSn, @RequestBody Comment comment) {
        comment.setSn(postSn);
        Comment updatedComment = commentService.updateComment(comment);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long postSn) {
        commentService.deleteComment(postSn);
        return ResponseEntity.ok().build();
    }
}