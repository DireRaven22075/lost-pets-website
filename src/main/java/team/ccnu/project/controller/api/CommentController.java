package team.ccnu.project.controller.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.ccnu.project.domain.entity.Comment;
import team.ccnu.project.service.CommentService;

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
    
    
    // 답글 기능을 위한 추가 메서드
    @PostMapping("/{pst}/reply")
    public ResponseEntity<Comment> addReply(@PathVariable Long pst, @RequestBody UploadReplyDTO replyDTO) {
        Comment savedReply = commentService.addReply(replyDTO, pst);    // 답글 저장
        return ResponseEntity.ok(savedReply);
    }

    @GetMapping("/{pst}/replies")
    public ResponseEntity<List<Comment>> getReplies(@PathVariable Long pst) {
        List<Comment> replies = commentService.getRepliesByCommentSn(pst); // 답글 목록 가져옴.
        return ResponseEntity.ok(replies);
    }
}