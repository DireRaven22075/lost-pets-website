package team.ccnu.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.domain.entity.User;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findBySn(Long sn);

}
