package team.ccnu.project.service;

import org.springframework.stereotype.Service;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    // PostRepository를 주입받아 사용합니다.
    private final PostRepository postRepository;

    // 생성자 주입을 통해 PostRepository를 초기화합니다.
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * 특정 게시판의 모든 게시글을 조회합니다.
     * @param boardId 게시판 ID
     * @return 게시글 목록
     */
    public List<Post> getAllPostsByBoardId(String boardId) {
        return postRepository.findByBoardId(boardId);
    }

    /**
     * 특정 게시판의 특정 게시글을 조회합니다.
     * @param id 게시글 ID
     * @param boardId 게시판 ID
     * @return 게시글 객체
     */
    public Post getPostByIdAndBoardId(Long id, String boardId) {
        return postRepository.findByIdAndBoardId(id, boardId);
    }

    /**
     * 게시글을 저장합니다.
     * @param post 저장할 게시글 객체
     */
    public void savePost(Post post) {
        postRepository.save(post);
    }

    /**
     * 특정 게시판의 특정 게시글을 삭제합니다.
     * @param id 게시글 ID
     * @param boardId 게시판 ID
     */
    public void deletePostByIdAndBoardId(Long id, String boardId) {
        Post post = postRepository.findByIdAndBoardId(id, boardId);
        if (post != null) {
            postRepository.delete(post);
        }
    }
}