package team.ccnu.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.ccnu.project.data.request.UploadCommentDTO;
import team.ccnu.project.domain.entity.Comment;
import team.ccnu.project.service.CommentService;

import java.util.List;

@RestController
// @RequestMapping("/api/boards/{boardId}/posts/{postId}/comments")    // 여기 이거 맞나?
@RequestMapping("/api/comment/{postId}")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments(@PathVariable Long postId) {
        List<Comment> comments = commentService.getAllCommentsByPostSn(postId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping
    public ResponseEntity<Comment> addComment(@PathVariable Long postId, @RequestBody UploadCommentDTO dto) {
        System.out.print(dto.getContent());
        System.out.println(postId.toString());
        commentService.addComment(dto, postId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getComment(@PathVariable Long commentId) {
        return commentService.getCommentBySn(commentId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId, @RequestBody Comment comment) {
        comment.setSn(commentId);
        Comment updatedComment = commentService.updateComment(comment);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }
}