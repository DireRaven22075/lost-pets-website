package team.ccnu.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.ccnu.project.domain.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostSn(Long postSn);
}