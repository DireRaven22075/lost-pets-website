package team.ccnu.project.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import team.ccnu.project.data.request.UploadPostDTO;
import team.ccnu.project.domain.entity.Image;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.domain.repository.PostRepository;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    //게시물 작성
    public Post createPost(UploadPostDTO postDTO) {
        Post post = new Post();
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
        return postRepository.findAll(pageable);
    }

    public Post uploadPost(UploadPostDTO dto) {
        try {
            Post post = new Post();
            post.setTitle(dto.getTitle());
            post.setContent(dto.getContent());
            post.setStatus(dto.getStatus());
            post.setUid(dto.getUid());
            postRepository.save(post);

            return post;
        } catch (Exception e) {
            return null;
        }
    }
    public Post uploadPost(UploadPostDTO dto, MultipartFile[] files) {
        try {
            Post post = new Post();
            post.setTitle(dto.getTitle());
            post.setContent(dto.getContent());
            post.setStatus(dto.getStatus());
            post.setUid(dto.getUid());
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                long fileSize = file.getSize();
                File directory = new File(System.getProperty("user.home") + "/uploads/adopt");
                if (!directory.exists()) {
                    if (!directory.mkdirs()) {
                        throw new Exception();
                    }
                }
                file.transferTo(new File(System.getProperty("user.home") + "/uploads/adopt/" + System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."))));
                //Image image = img.uploadImge(file);
            }


            postRepository.save(post);
            return post;
        } catch (Exception e) {
            return null;
        }
    }
}
