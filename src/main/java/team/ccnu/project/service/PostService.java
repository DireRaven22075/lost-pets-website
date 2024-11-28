package team.ccnu.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
=======
>>>>>>> Stashed changes
import org.springframework.stereotype.Service;

import team.ccnu.project.data.request.UploadPostDTO;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.domain.repository.PostRepository;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    //게시물 작성

<<<<<<< Updated upstream
    public Post createPost(PostDTO postDTO) {
        Post post = new Post();
        post.setUid(0L); // 게시판 ID 설정
=======
    public Post createPost(UploadPostDTO postDTO) {
        Post post = new Post();
>>>>>>> Stashed changes
        post.setTitle(postDTO.getTitle()); // 게시물 제목 설정
        post.setContent(postDTO.getContent()); // 게시물 내용 설정
        post.setStatus(postDTO.getStatus()); // 게시물 상태 설정
        post.setUid(postDTO.getUid()); // 게시판 ID 설정

        postRepository.save(post); // 게시물 저장
        return post;
    }




    //특정 게시물 조회
    public Post getPostBySn(Long sn) {
        return postRepository.findBySn(sn);
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    //모든 게시판 모든 게시물 조회
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    //게시물 삭제

    public void deletePost(Long sn) {
        Post post = postRepository.findBySn(sn);
        postRepository.deleteBySn(sn);
    }

    public Post updatePost(Long postSn, UploadPostDTO postDTO) {
        Post post = postRepository.findById(postSn).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(postDTO.getTitle()); // 게시물 제목 수정
        post.setContent(postDTO.getContent()); // 게시물 내용 수정
        post.setStatus(postDTO.getStatus()); // 게시물 상태 수정
        post.setUid(postDTO.getUid()); // 게시판 ID 수정

        postRepository.save(post); // 게시물 저장
        return post;
    }

    //




    // public void uploadFiles(Long postSn, MultipartFile[] files) throws IOException {
    //     // 파일 저장 경로 설정
    //     String uploadDir = "uploads/" + postSn;
    //     File dir = new File(uploadDir);
    //     if (!dir.exists()) {
    //         dir.mkdirs(); // 디렉토리 생성
    //     }

    //     // 파일 저장 로직 구현
    //     for (MultipartFile file : files) {
    //         String filePath = uploadDir + "/" + file.getOriginalFilename();
    //         File dest = new File(filePath);
    //         file.transferTo(dest); // 파일 저장
    //     }
    // }

    public Page<Post> getPostsByPageByIndex(Long bbs, int index) {
        Pageable pageable = PageRequest.of(index, 20);

        return postRepository.findBy(pageable);
    }
}
