package team.ccnu.project.domain.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import team.ccnu.project.domain.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findBySn(Long sn);
    void deleteBySn(Long sn);
    List<Post> findAll();
}