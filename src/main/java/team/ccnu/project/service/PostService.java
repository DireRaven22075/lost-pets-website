package team.ccnu.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import team.ccnu.project.service.PostService;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.domain.repository.PostRepository;
import team.ccnu.project.data.response.PostDTO;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    //게시물 작성

    public Post createPost(Long uid, PostDTO postDTO) {
        Post post = new Post();
        post.setUid(uid); // 게시판 ID 설정
        post.setTitle(postDTO.getTitle()); // 게시물 제목 설정
        post.setContent(postDTO.getContent()); // 게시물 내용 설정
        post.setView(0L); // 조회수 0으로 초기화
        post.setStatus('Y'); // 게시물 상태 설정
        return postRepository.save(post); // 게시물 저장
    }

    //게시판에서 게시물 조회
    public List<Post> getAllPostsByBoardId(Long boardId) {
        return postRepository.findPostsByUid(boardId);
    }

    //특정 게시물 조회
    public Post getPostBySn(Long sn) {
        return postRepository.findBySn(sn);
    }

    //모든 게시판 모든 게시물 조회
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }


    //게시물 조회수 증가
    public void increaseViewCount(Long sn) {
        Post post = postRepository.findBySn(sn);
        post.setView(post.getView() + 1);
        postRepository.save(post);
    }

    //게시물 삭제

    public void deletePost(Long userId, Long sn) {
        Post post = postRepository.findBySn(sn);
        postRepository.deleteById(sn);
    }

    // 게시물 수정
    public void updatePost(Long userId, Long sn, Long uid, PostDTO postDTO) {
        Post post = postRepository.findBySn(sn);
        post.setUid(uid); // 게시판 ID 설정
        post.setTitle(postDTO.getTitle()); // 게시물 제목 설정
        post.setContent(postDTO.getContent()); // 게시물 내용 설정
        postRepository.save(post); // 게시물 저장
    }

    //게시물 상태 변경
    public void changePostStatus(Long sn, char status) {
        Post post = postRepository.findBySn(sn);
        post.setStatus(status);
        postRepository.save(post);
    }


}
