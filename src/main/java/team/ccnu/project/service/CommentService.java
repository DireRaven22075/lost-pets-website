package team.ccnu.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.ccnu.project.data.request.UploadCommentDTO;
import team.ccnu.project.domain.entity.Comment;
import team.ccnu.project.domain.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllCommentsByPostSn(Long postSn) {
        return commentRepository.findByPost_Sn(postSn);
    }

    public Comment addComment(UploadCommentDTO dto, Long postId) {
        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        return commentRepository.save(comment);
    }
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }
    public Optional<Comment> getCommentBySn(Long sn) {
        return commentRepository.findById(sn);
    }

    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(Long sn) {
        commentRepository.deleteById(sn);
    }


    // 답글 기능을 위한 추가 메서드
    public Comment addReply(Long parentCommentSn, Comment reply) {
        Comment parentComment = commentRepository.findById(parentCommentSn)             // 부모 댓글의 SN 받아 해당 댓글 찾음
                .orElseThrow(() -> new RuntimeException("Parent comment not found"));

        reply.setParentComment(parentComment);      // 새 답글에 부모 댓글과
        reply.setPost(parentComment.getPost());     // 게시물 정보 설정
        // reply.setIsReply(true);                     // true로 설정하여 답글임을 표시

        return commentRepository.save(reply);       // 답글을 저장하고 반환
    }

    // 답글 기능을 위한 추가 메서드. 특정 댓글에 대한 모든 답글을 조회
    public List<Comment> getRepliesByCommentSn(Long commentSn) {
        return commentRepository.findByParentComment_SnAndIsReplyTrue(commentSn);   // isReply가 true인 댓글만 반환
    }
}