package team.ccnu.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.ccnu.project.domain.entity.Image;
import team.ccnu.project.domain.entity.Post;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByPost(Post post);
}
