package team.ccnu.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.ccnu.project.domain.entity.Comment;
import team.ccnu.project.service.CommentService;
import team.ccnu.project.data.request.UploadCommentDTO;

import java.util.List;

@RestController
@RequestMapping("/api/boards/{boardId}/posts/{postId}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /// <summary>
    /// 특정 게시글의 모든 댓글을 조회하는 함수
    /// [GET] /api/boards/{boardId}/posts/{postId}/comments
    /// </summary>
    @GetMapping("")
    public ResponseEntity<List<Comment>> getAll(@PathVariable Long boardId, @PathVariable Long postId) {
        List<Comment> comments = commentService.getAllCommentsByPostId(postId);
        return ResponseEntity.ok(comments);
    }

    /// <summary>
    /// 특정 게시글에 댓글을 추가하는 함수
    /// [POST] /api/boards/{boardId}/posts/{postId}/comments
    /// </summary>
    @PostMapping("")
    public ResponseEntity<?> add(@PathVariable Long boardId, @PathVariable Long postId, @RequestBody UploadCommentDTO dto) {
        try {
            Comment comment = new Comment();
            comment.setPostId(postId);
            comment.setContent(dto.getContent());
            commentService.saveComment(comment);
            return ResponseEntity.status(HttpStatus.CREATED).body("{\"status\": \"success\", \"message\": \"Comment added successfully\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\": \"error\", \"message\": \"Internal Server Error\"}");
        }
    }

    /// <summary>
    /// 특정 댓글을 조회하는 함수
    /// [GET] /api/boards/{boardId}/posts/{postId}/comments/{commentId}
    /// </summary>
    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> get(@PathVariable Long boardId, @PathVariable Long postId, @PathVariable Long commentId) {
        Comment comment = commentService.getCommentById(commentId);
        if (comment != null) {
            return ResponseEntity.ok(comment);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /// <summary>
    /// 특정 댓글을 수정하는 함수
    /// [PUT] /api/boards/{boardId}/posts/{postId}/comments/{commentId}
    /// </summary>
    @PutMapping("/{commentId}")
    public ResponseEntity<?> update(@PathVariable Long boardId, @PathVariable Long postId, @PathVariable Long commentId, @RequestBody UploadCommentDTO dto) {
        try {
            Comment comment = commentService.getCommentById(commentId);
            if (comment != null) {
                comment.setContent(dto.getContent());
                commentService.saveComment(comment);
                return ResponseEntity.ok("{\"status\": \"success\", \"message\": \"Comment updated successfully\"}");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": \"error\", \"message\": \"Comment not found\"}");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\": \"error\", \"message\": \"Internal Server Error\"}");
        }
    }

    /// <summary>
    /// 특정 댓글을 삭제하는 함수
    /// [DELETE] /api/boards/{boardId}/posts/{postId}/comments/{commentId}
    /// </summary>
    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> delete(@PathVariable Long boardId, @PathVariable Long postId, @PathVariable Long commentId) {
        try {
            boolean deleted = commentService.deleteComment(commentId);
            if (deleted) {
                return ResponseEntity.ok("{\"status\": \"success\", \"message\": \"Comment deleted successfully\"}");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": \"error\", \"message\": \"Comment not found\"}");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\": \"error\", \"message\": \"Internal Server Error\"}");
        }
    }
}