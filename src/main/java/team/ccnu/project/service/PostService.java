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
        Pageable pageable = PageRequest.of(page, size);
        return postRepository.findAll(pageable);
    }

    public Post getPostBySn(Long sn) {
        return postRepository.findBySn(sn);
    }


// 1. UploadPostDTO에는 title과 content 필드가 있습니다.
// 2. Post 엔티티에는 setTitle(), setContent(), setFileNames() 메서드가 있습니다.
// 3. 파일 업로드 처리는 PostService에서 수행합니다.
//  프로젝트의 요구사항과 엔티티 구조에 맞게 코드를 조정
//    public Post updatePost(Long bbs, Long postSn, UploadPostDTO dto) {
//        Post post = postRepository.findBySn(postSn);
//        if (post != null) {
//            post.setTitle(dto.getTitle());
//            post.setContent(dto.getContent());
//            // 필요한 다른 필드들도 업데이트
//            return postRepository.save(post);
//        }
//        return null;
//    }
//
//    public boolean deletePost(Long bbs, Long postSn) {
//        Post post = postRepository.findBySn(postSn);
//        if (post != null) {
//            postRepository.delete(post);
//            return true;
//        }
//        return false;
//    }
//
//    public Post createPost(Long bbs, UploadPostDTO dto, List<MultipartFile> files) throws IOException {
//        Post post = new Post();
//        post.setTitle(dto.getTitle());
//        post.setContent(dto.getContent());
//        // 필요한 다른 필드들도 설정
//
//        // 파일 처리
//        List<String> fileNames = new ArrayList<>();
//        for (MultipartFile file : files) {
//            if (!file.isEmpty()) {
//                String fileName = saveFile(file);
//                fileNames.add(fileName);
//            }
//        }
//        post.setFileNames(fileNames); // Post 엔티티에 파일 이름 목록을 저장하는 필드가 있다고 가정
//
//        return postRepository.save(post);
//    }
//
//    private String saveFile(MultipartFile file) throws IOException {
//        String fileName = file.getOriginalFilename();
//        Path filePath = Paths.get("uploads/" + fileName);
//        Files.createDirectories(filePath.getParent());
//        Files.write(filePath, file.getBytes());
//        return fileName;
//    }
}