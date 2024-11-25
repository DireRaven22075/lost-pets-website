package team.ccnu.project.domain.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import team.ccnu.project.domain.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findBySn(Long sn);

    List<Post> findPostsByUid(Long uid);
}