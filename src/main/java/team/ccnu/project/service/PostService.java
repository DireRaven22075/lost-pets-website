package team.ccnu.project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.domain.repository.PostRepository;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public Page<Post> getPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size); // 페이지 번호와 크기
        return postRepository.findAll(pageable);
    }
}
