package team.ccnu.project.domain.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import team.ccnu.project.domain.entity.Post;

/**
 * Post 엔티티에 대한 데이터베이스 접근을 처리하는 리포지토리 인터페이스입니다.
 */
public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAll(Pageable pageable);
}
    
    /**
     * 게시글의 시리얼 넘버(sn)로 게시글을 조회합니다.
     * @param sn 시리얼 넘버
     * @return 게시글 객체
     */
    Post findBySn(Long sn);

    /**
     * 특정 게시판의 모든 게시글을 조회합니다.
     * @param boardId 게시판 ID
     * @return 게시글 목록
     */
    List<Post> findByBoardId(Long boardId);

    /**
     * 특정 게시판의 특정 게시글을 조회합니다.
     * @param id 게시글 ID
     * @param boardId 게시판 ID
     * @return 게시글 객체
     */
    Post findByIdAndBoardId(Long id, Long boardId);
}
