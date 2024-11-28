package team.ccnu.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.ccnu.project.domain.entity.Comment;
import team.ccnu.project.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{pst}")
    public ResponseEntity<List<Comment>> getAllComments(@PathVariable Long pst) {
        List<Comment> comments = commentService.getAllCommentsByPostSn(pst);
        return ResponseEntity.ok(comments);
    }

    @PostMapping("/{pst}")
    public ResponseEntity<Comment> addComment(@PathVariable Long pst, @RequestBody Comment comment) {
        comment.getPost().setSn(pst);
        Comment savedComment = commentService.addComment(comment);
        return ResponseEntity.ok(savedComment);
    }

    @PutMapping("/{pst}/{cmnt}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long pst, @PathVariable Long cmnt, @RequestBody Comment comment) {
        comment.setSn(cmnt);
        comment.getPost().setSn(pst);
        Comment updatedComment = commentService.updateComment(comment);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{pst}/{cmnt}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long cmnt) {
        commentService.deleteComment(cmnt);
        return ResponseEntity.ok().build();
    }
}