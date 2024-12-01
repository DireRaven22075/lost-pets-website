package team.ccnu.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.ccnu.project.domain.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost_Sn(Long postSn);

    // 답글 기능을 위한 추가 메서드: 특정 부모 댓글의 답글을 조회할 수 있도록 한다. 부모 댓글의 SN을 받아 해당 댓글에 대한 답글들을 반환한다.
    List<Comment> findByParentComment_SnAndIsReplyTrue(Long parentCommentSn);
}