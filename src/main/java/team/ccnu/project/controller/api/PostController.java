package team.ccnu.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import team.ccnu.project.data.request.UploadPostDTO;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.service.PostService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/posts/{bbs}")
public class PostController {
    @Autowired
    PostService postService;
    /// <summary>
    /// TODO : 구현 필요
    /// 특정 게시판 내 모든 게시글 불러오기
    /// </summary>
    @GetMapping
    public String getAllPosts(@PathVariable Long bbs) {

        return "success";
    }
    /// <summary>
    /// TODO : 구현 필요
    /// 특정 게시판 내 게시글을 추가
    ///
    /// [POST] 특정 게시판 내 게시글을 추가하하는 함수
    /// </summary>
    @PostMapping
    public ResponseEntity<?> apiAddPost(
            @RequestPart("data") UploadPostDTO dto,
            @PathVariable Long bbs,
            @RequestParam("files") List<MultipartFile> files) {
        try {
            System.out.println(bbs);
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    Path filePath = Paths.get("uploads/" + file.getOriginalFilename());
                    Files.createDirectories(filePath.getParent());
                    Files.write(filePath, file.getBytes());
                    System.out.println("Uploaded: " + file.getOriginalFilename());
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
            {"status": "error", "message": "Internal Server Error"}
            """);
        }
        return ResponseEntity.status(HttpStatus.OK).body("""
        {"status": "success", "message": "Post Upload Success.."}
        """);
    }
    /// <summary>
    /// [GET] 특정 게시판 내 특정 게시글을 가져오는 함수
    /// TODO : 구현 필요
    /// </summary>
    @GetMapping("/{postId}")
    public String get(@PathVariable String boardId, @PathVariable String postId) {
        return "success";
    }
    /// <summary>
    /// [PUT] 특정 게시판 내 게시글을 수정하는 함수
    /// TODO : 구현 필요
    /// </summary>
    @PutMapping("/{postId}")
    public String update(@PathVariable String boardId, @PathVariable String postId) {
        return "success";
    }
    /// <summary>
    /// [DELETE] 특정 게시판 내 게시글 삭제하는 함수
    /// TODO : 구현 필요
    /// </summary>
    @DeleteMapping("/{postId}")
    public String delete(@PathVariable String boardId, @PathVariable String postId) {
        return "success";
    }
}