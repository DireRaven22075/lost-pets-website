package team.ccnu.project.controller.api;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<?> apiCreatePost(
            @ModelAttribute UploadPostDTO dto
    ) {
        // 경로 설정
        String sysPath = System.getProperty("user.home") + "/uploads";
        String path = determinePathBasedOnUid(dto.getUid(), sysPath);

        // 게시글 생성
        Post post = postService.createPost(dto);
        if (post == null) {
            return ResponseEntity.internalServerError().body("Failed to create post.");
        }

        // 파일 처리
        if (dto.getFiles() != null && !dto.getFiles().isEmpty()) {
            File directory = new File(sysPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            try {
                for (MultipartFile file : dto.getFiles()) {
                    String filename = generateUniqueFilename(file);
                    File destFile = new File(sysPath + filename);
                    file.transferTo(destFile); // 파일 저장
                    // 이미지 저장 및 DB 처리
                    Image image = img.addImage(path + filename);
                    img.save(image); // 이미지 DB 저장

                    image.setPost(post);
                    post.addFile(image);
                }

                postService.savePost(post); // 게시글 저장 (파일 정보와 함께)

            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).severe("Error while processing files: " + e.getMessage());
                return ResponseEntity.internalServerError().body("Error while processing files.");
            }
        }
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
//         try {
//             Post post = postService.uploadPost(dto);
//             Long uid = post.getUid();
//             if (uid == 0L) {
//                 sysPath += "/adopt";
//                 path += "/adopt";
//             } else if (uid == 1L) {
//                 sysPath += "/report";
//                 path += "/report";
//             } else if (uid == 2L) {
//                 sysPath += "/education";
//                 path += "/education";
//             }
//             if (files != null && files.size() > 0) {
//                 File directory = new File(sysPath);
//                 if (!directory.exists()) {
//                     directory.mkdirs();
//                 }
//                 for (MultipartFile file : files) {
//                     String format = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//                     String name = System.currentTimeMillis() + format;
//                     file.transferTo(new File(sysPath+name));
//                     Image image = img.addImage(path + name + format);
//                     image.setPost(post);
//                     post.addFile(image);
//                     postService.savePost(post);
//                     img.save(image);
//                 }
//             }
//             return ResponseEntity.status(200).body("""
//             {"status": "success", "message": "Upload Success."}
//             """);
////        try {
//            Post post = new Post();
//            post.setTitle(dto.getTitle());
//            post.setContent(dto.getContent());
//            post.setStatus(dto.getStatus());
//            post.setUid(dto.getUid());
//
//            postService.savePost(post);
//
//            return ResponseEntity.ok().body("""
//                    {"status": "success", "message": "Post created successfully"}
//                    """);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
//                    {"status": "error", "message": "Internal Server Error"}
//                    """);
//        }

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
    ///
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