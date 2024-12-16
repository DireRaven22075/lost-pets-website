package team.ccnu.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.ccnu.project.domain.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostSn(Long post_sn);
    List<Comment> findByPost_Sn(Long postSn);
}