package team.ccnu.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.ccnu.project.data.request.UploadPostDTO;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.service.PostService;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    /// <게시글 추가>
    @PostMapping
    public ResponseEntity<?> apiCreatePost(@RequestBody UploadPostDTO postDTO) {
        try {
            Post post = new Post();
            post.setTitle(postDTO.getTitle());
            post.setContent(postDTO.getContent());
            post.setStatus(postDTO.getStatus());
            post.setUid(postDTO.getUid());

            postService.savePost(post);

            return ResponseEntity.ok().body("""
                    {"status": "success", "message": "Post created successfully"}
                    """);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
                    {"status": "error", "message": "Internal Server Error"}
                    """);
        }
    }

    /// <게시글 삭제>
    /// api -dto를 return하는 것이 아니라, responseEntity를 return하는 것이 맞다.
    /// 계정이 있는 경우에만 삭제 할 수 있도록 
    @DeleteMapping("/{postSn}")
    public ResponseEntity<?> apiDeletePost(@PathVariable Long postSn) {
        try {
            postService.deletePost(postSn);
            return ResponseEntity.ok().body("""
                    {"status": "success", "message": "Post deleted successfully"}
                    """);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
                    {"status": "error", "message": "Internal Server Error"}
                    """);
        }
    }

    /// <게시글 수정>
    @PutMapping("/{postSn}")
    public ResponseEntity<?> apiUpdatePost(@PathVariable Long postSn, @RequestBody UploadPostDTO postDTO) {
        try {
            Post post = postService.updatePost(postSn, postDTO);
            return ResponseEntity.ok().body("""
                    {"status": "success", "message": "Post updated successfully"}
                    """);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
                    {"status": "error", "message": "Internal Server Error"}
                    """);
        }
    }
}