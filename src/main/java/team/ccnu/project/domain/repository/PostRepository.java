package team.ccnu.project.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.domain.entity.User;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAll(Pageable pageable);

    // 추가된 메서드
    Post findBySn(Long sn);
}
