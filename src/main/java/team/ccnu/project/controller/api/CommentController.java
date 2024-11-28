package team.ccnu.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.ccnu.project.domain.entity.Comment;
import team.ccnu.project.service.CommentService;
import team.ccnu.project.data.request.UploadCommentDTO;
import team.ccnu.project.data.request.DeleteCommentDTO;

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
    public ResponseEntity<Comment> addComment(@PathVariable Long pst, @RequestBody UploadCommentDTO uploadCommentDTO) {
        Comment comment = new Comment();
        comment.setContent(uploadCommentDTO.getContent());
        comment.getPost().setSn(pst);
        Comment savedComment = commentService.addComment(comment);
        return ResponseEntity.ok(savedComment);
    }

    @PutMapping("/{pst}/{cmnt}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long pst, @PathVariable Long cmnt, @RequestBody UploadCommentDTO uploadCommentDTO) {
        Comment comment = commentService.getCommentBySn(cmnt)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        comment.setContent(uploadCommentDTO.getContent());
        Comment updatedComment = commentService.updateComment(comment);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{pst}/{cmnt}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long pst, @PathVariable Long cmnt, @RequestBody DeleteCommentDTO deleteCommentDTO) {
        if (!cmnt.equals(deleteCommentDTO.getCommentSn())) {
            return ResponseEntity.badRequest().build();
        }
        commentService.deleteComment(cmnt);
        return ResponseEntity.ok().build();
    }
}