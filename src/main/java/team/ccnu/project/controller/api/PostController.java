package team.ccnu.project.controller.api;

import java.beans.BeanProperty;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation. RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.domain.entity.User;
import team.ccnu.project.service.PostService;
import team.ccnu.project.data.response.PostDTO;







@RestController
@RequestMapping("/api/posts/{bbs}")
public class PostController {
    @Autowired
    private PostService postService;

    // @PostMapping 
    // public ResponseEntity<?> apiUploadPost(
    //         @RequestParam("files") MultipartFile[] files,
    //         @RequestParam("data") UploadPostDTO data,
    //         @PathVariable Long bbs) {
    //     //파일 저장 경로 = uploads/{post.sn 값을 이용해서 작성}
    //     return ResponseEntity.ok().build();
    // }
    /// <특정 게시판 내 모든 게시글 조회>
    @GetMapping
    public ResponseEntity<?> apiGetAllPosts(@PathVariable Long bbs) {
        try {
            List<Post> posts = postService.getAllPostsByBoardId(bbs);
            List<PostDTO> postDTOs = posts.stream()
                                          .map(post -> new PostDTO(post))
                                          .toList(); // Java 16 이상
            return ResponseEntity.ok().body("""
                {"status": "success", "data": %s}
                """.formatted(postDTOs));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
                {"status": "error", "message": "Internal Server Error"}
                """);
        }
    }
    
    
    
    /// <특정 게시판 내 특정 게시글 조회>
    @GetMapping("/{postId}")
    public ResponseEntity<?> apiGetPostByID(@PathVariable Long bbs, @PathVariable Long postId) {
        try {
            Post post = postService.getPostBySn(postId);
            if (post == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("""
                    {"status": "error", "message": "Post not found"}
                    """);
            }
            PostDTO postDTO = new PostDTO(post);
            return ResponseEntity.ok().body("""
                {"status": "success", "data": %s}
                """.formatted(postDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
                {"status": "error", "message": "Internal Server Error"}
                """);
        }
    }
    
    
    /// <특정 게시판 내 게시글 추가>
    @PostMapping
    public ResponseEntity<?> apiCreatePost(@PathVariable Long bbs, @RequestBody PostDTO postDTO) {
        try {
            Post post = postService.createPost(bbs, postDTO);
            PostDTO responseDTO = new PostDTO(post);
            return ResponseEntity.ok().body("""
                {"status": "success", "data": %s}
                """.formatted(responseDTO));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
                    {"status": "error", "message": "Internal Server Error"}
                    """);
            }
        } 

    

    /// <특정 게시글 수정>
    //@PutMapping("/{postId}")
    //public ResponseEntity<?> apiUpdatePost(@PathVariable Long bbs, @PathVariable Long postId, @RequestBody PostDTO postDTO) {
        // 현재 인증된 사용자 정보 가져오기

        // User 객체를 가져오는 로직 (예: UserService를 통해 가져오기)
        //todo

    //     // 게시물 수정
    //     try {
    //         boolean isUpdated = postService.updatePost(user.getId(), postId, bbs, postDTO);
    //         if (isUpdated) {
    //             return ResponseEntity.ok().body("""
    //                 {"status": "success", "message": "Post updated successfully"}
    //                 """);
    //         } else {
    //             return ResponseEntity.status(HttpStatus.FORBIDDEN).body("""
    //                 {"status": "error", "message": "You are not authorized to update this post"}
    //                 """);
    //         }
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
    //             {"status": "error", "message": "Internal Server Error"}
    //             """);
    //     }
    // }

    // <특정 게시글 삭제>
//    @DeleteMapping("/{postId}")
//        boolean isDeleted = postService.deletePost(user.getId(), postId);
//        if (isDeleted) {
//            return ResponseEntity.ok().body("""
//                {"status": "success", "message": "Post deleted successfully"}
//                """);
//        } else {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("""
//                {"status": "error", "message": "You are not authorized to delete this post"}
//                """);
//
//    }
}


// key: status message
//status: success error
//message: english

