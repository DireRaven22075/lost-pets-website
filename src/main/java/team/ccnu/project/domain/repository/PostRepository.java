package team.ccnu.project.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import team.ccnu.project.domain.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findBySn(Long sn);
    void deleteBySn(Long sn);

   

    List<Post> findPostsByUid(Long uid);

<<<<<<< Updated upstream
    Page<Post> findBy(Pageable pageable);
=======
>>>>>>> Stashed changes
}