package team.ccnu.project.controller.api;

import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import team.ccnu.project.data.response.PostDTO;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.service.PostService;
import team.ccnu.project.service.ImageService;
import team.ccnu.project.data.request.UploadPostDTO;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private ImageService img;

    /// <게시글 추가>
    @PostMapping
    public ResponseEntity<?> apiCreatePost(
            @RequestParam("files") List<MultipartFile> files,
            @RequestPart("data") UploadPostDTO dto) {
        // String sysPath = System.getProperty("user.home") + "/uploads" ;
        // String path = "";
        // try {
        //     Post post = postService.createPost(dto);
        //     Long uid = post.getUid();
        //     if (uid == 0L) {
        //         sysPath += "/adopt";
        //         path += "/adopt";
        //     } else if (uid == 1L) {
        //         sysPath += "/report";
        //         path += "/report";
        //     } else if (uid == 2L) {
        //         sysPath += "/education";
        //         path += "/education";
        //     } else {
        //         throw new Exception();
        //     }
        //     if (files != null && files.size() > 0) {
        //         File directory = new File(sysPath);
        //         if (!directory.exists()) {
        //             if (!directory.mkdirs()) {
        //                 throw new Exception();
        //             }
        //         }
        //         for (MultipartFile file : files) {
        //             String format = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //             String name = System.currentTimeMillis() + format;
        //             file.transferTo(new File(sysPath+name));
        //             Image image = img.addImage(path + name + format);
        //             image.setPost(post);
        //             post.addFile(image);
        //             postService.savePost(post);
        //             img.save(image);
        //         }
        //     }
        //     return ResponseEntity.status(200).body("""
        //     {"status": "success", "message": "Upload Success."}      
        //     """);
        try {
            Post post = new Post();
            post.setTitle(dto.getTitle());
            post.setContent(dto.getContent());
            post.setStatus(dto.getStatus());
            post.setUid(dto.getUid());

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

    /// <summary>
    /// 포스트 업로드 처리 핸들러
    /// @Param files : MulipartFile[] : 이미지 파일들을 받아오는 인자
    /// @Param dto : UploadPostDTO : 게시글 관련 값들을 받아오는 인자
    /// @Return ResponseEntity
    /// </summary>
    @PostMapping("/test")
    public ResponseEntity<?> apiUploadPost(
            @RequestParam("files") MultipartFile[] files
    ) {
        try {
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

            return ResponseEntity.ok("Files uploaded successfully: " + files.length + " files");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("File upload failed");
        }
    }
}