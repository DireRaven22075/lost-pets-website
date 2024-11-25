package team.ccnu.project.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.ccnu.project.data.request.UploadPostDTO;
import team.ccnu.project.data.response.PostDTO;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/boards/{boardId}/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    /// <summary>
    /// TODO : 구현 필요
    /// 특정 게시판 내 모든 게시글 불러오기
    /// </summary>
    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts(@PathVariable String boardId) {
        // Fetch all posts for the given boardId
        List<Post> posts = postService.getAllPostsByBoardId(boardId);
        List<PostDTO> postDTOs = posts.stream()
                                      .map(post -> new PostDTO(post.getOwner(), post.getTitle(), post.getContent(), post.getView()))
                                      .collect(Collectors.toList());
        return ResponseEntity.ok(postDTOs);
    }

    /// <summary>
    /// TODO : 구현 필요
    /// 특정 게시판 내 게시글을 추가
    ///
    /// [POST] 특정 게시판 내 게시글을 추가하하는 함수
    /// </summary>
    @PostMapping
    public ResponseEntity<?> apiAddPost(@PathVariable String boardId, @RequestBody UploadPostDTO dto) {
        try {
            Post post = new Post();
            post.setTitle(dto.getTitle());
            post.setContent(dto.getContent());
            post.setBoardId(boardId);
            postService.savePost(post);
            return ResponseEntity.status(HttpStatus.CREATED).body("{\"status\": \"success\", \"message\": \"Post created successfully\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\": \"error\", \"message\": \"Internal Server Error\"}");
        }
    }

    /// <summary>
    /// [GET] 특정 게시판 내 특정 게시글을 가져오는 함수
    /// TODO : 구현 필요
    /// </summary>
    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> get(@PathVariable String boardId, @PathVariable String postId) {
        Post post = postService.getPostByIdAndBoardId(postId, boardId);
        if (post == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        PostDTO postDTO = new PostDTO(post.getOwner(), post.getTitle(), post.getContent(), post.getView());
        return ResponseEntity.ok(postDTO);
    }

    /// <summary>
    /// [PUT] 특정 게시판 내 게시글을 수정하는 함수
    /// TODO : 구현 필요
    /// </summary>
    @PutMapping("/{postId}")
    public ResponseEntity<?> update(@PathVariable String boardId, @PathVariable String postId, @RequestBody UploadPostDTO dto) {
        try {
            Post post = postService.getPostByIdAndBoardId(postId, boardId);
            if (post == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": \"error\", \"message\": \"Post not found\"}");
            }
            post.setTitle(dto.getTitle());
            post.setContent(dto.getContent());
            postService.savePost(post);
            return ResponseEntity.ok("{\"status\": \"success\", \"message\": \"Post updated successfully\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\": \"error\", \"message\": \"Internal Server Error\"}");
        }
    }

    /// <summary>
    /// [DELETE] 특정 게시판 내 게시글 삭제하는 함수
    /// TODO : 구현 필요
    /// </summary>
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> delete(@PathVariable String boardId, @PathVariable String postId) {
        try {
            postService.deletePostByIdAndBoardId(postId, boardId);
            return ResponseEntity.ok("{\"status\": \"success\", \"message\": \"Post deleted successfully\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\": \"error\", \"message\": \"Internal Server Error\"}");
        }
    }

    
}