package team.ccnu.project.controller.api;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import team.ccnu.project.data.response.PostDTO;
import team.ccnu.project.domain.entity.Image;
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
    @Transactional
    public ResponseEntity<?> apiCreatePost(@ModelAttribute UploadPostDTO dto) {
        Post post = Post.builder()
            .title(dto.getTitle())
            .content(dto.getContent())
            .status(dto.getStatus())
            .uid(dto.getUid())
            .build();
        
        if (dto.getFiles() != null && !dto.getFiles().isEmpty()) {
            for (MultipartFile file : dto.getFiles()) {
                String filename = generateUniqueFilename(file);
                String path = determinePathBasedOnUid(dto.getUid(), System.getProperty("user.home") + "/uploads");
                
                try {
                    File destFile = new File(path + filename);
                    file.transferTo(destFile);
                    
                    Image image = Image.builder()
                        .path(path + filename)
                        .post(post)
                        .build();
                    
                    post.getFiles().add(image);
                } catch (IOException e) {
                    return ResponseEntity.internalServerError().body("Error while processing files.");
                }
            }
        }
        
        postService.save(post);
        
        return ResponseEntity.ok(Map.of("status", "success", "message", "Post uploaded successfully!"));
    }
    // 게시글의 UID에 따른 경로 결정
    private String determinePathBasedOnUid(Long uid, String sysPath) {
        String path = sysPath;
        if (uid == 0L) {
            path += "/adopt";
        } else if (uid == 1L) {
            path += "/report";
        } else if (uid == 2L) {
            path += "/education";
        }
        return path;
    }

    // 파일 이름을 고유하게 생성하는 방법
    private String generateUniqueFilename(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String format = originalFilename.substring(originalFilename.lastIndexOf("."));
        return System.currentTimeMillis() + format; // 고유한 파일 이름 생성
    }

    /// <게시글 삭제>
    @DeleteMapping("/{postSn}")
    public ResponseEntity<?> apiDeletePost(@PathVariable Long postSn) {
        try {
            postService.deletePost(postSn);
            return ResponseEntity.ok().body(Map.of("status", "success", "message", "Post deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("status", "error", "message", "Internal Server Error"));
        }
    }

    /// <게시글 수정>
    @PutMapping("/{postSn}")
    public ResponseEntity<?> apiUpdatePost(@PathVariable Long postSn, @RequestBody UploadPostDTO postDTO) {
        try {
            Post post = postService.updatePost(postSn, postDTO);
            return ResponseEntity.ok().body(Map.of("status", "success", "message", "Post updated successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("status", "error", "message", "Internal Server Error"));
        }
    }

    /// <summary>
    /// 포스트 업로드 처리 핸들러
    ///
    /// @Param files : MulipartFile[] : 이미지 파일들을 받아오는 인자
    /// @Param dto : UploadPostDTO : 게시글 관련 값들을 받아오는 인자
    /// @Return ResponseEntity
    /// </summary>
    @PostMapping("/test")
    public ResponseEntity<?> apiUploadPost(@RequestParam("files") MultipartFile[] files) {
        try {
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                File directory = new File(System.getProperty("user.home") + "/uploads/adopt");
                if (!directory.exists()) {
                    if (!directory.mkdirs()) {
                        throw new Exception();
                    }
                }
                file.transferTo(new File(System.getProperty("user.home") + "/uploads/adopt/" + System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."))));
            }

            return ResponseEntity.ok("Files uploaded successfully: " + files.length + " files");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("File upload failed");
        }
    }
}
//     @PostMapping("/test")
//     public ResponseEntity<?> apiUploadPost(
//                     long fileSize = file.getSize();
//         @RequestParam("files") MultipartFile[] files
//     ) {
//         try {
//             for (MultipartFile file : files) {
//                 String fileName = file.getOriginalFilename();
//                 long fileSize = file.getSize();
//                 File directory = new File(System.getProperty("user.home") + "/uploads/adopt");
//                 if (!directory.exists()) {
//                     if (!directory.mkdirs()) {
//                         throw new Exception();
//                               //Image image = img.uploadImge(file);
//       }
//                 }
//                 file.transferTo(new File(System.getProperty("user.home") + "/uploads/adopt/" + System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."))));
//                 //Image image = img.uploadImge(file);
//             }

//             return ResponseEntity.ok("Files uploaded successfully: " + files.length + " files");
//         } catch (Exception e) {
//             e.printStackTrace();
//             return ResponseEntity.status(500).body("File upload failed");
//         }
//     }
// }