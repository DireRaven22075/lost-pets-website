package team.ccnu.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import team.ccnu.project.data.request.DeletePostDTO;
import team.ccnu.project.data.request.UploadPostDTO;
import team.ccnu.project.data.response.PostDTO;
import team.ccnu.project.domain.entity.Image;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.service.ImageService;
import team.ccnu.project.service.PostService;

import java.io.File;
import java.rmi.server.ExportException;
import java.util.List;


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
        String sysPath = System.getProperty("user.home") + "/uploads" ;
        String path = "";
        try {
            Post post = postService.createPost(dto);
            Long uid = post.getUid();
            if (uid == 0L) {
                sysPath += "/adopt";
                path += "/adopt";
            } else if (uid == 1L) {
                sysPath += "/report";
                path += "/report";
            } else if (uid == 2L) {
                sysPath += "/education";
                path += "/education";
            } else {
                throw new Exception();
            }
            if (files != null && files.size() > 0) {
                File directory = new File(sysPath);
                if (!directory.exists()) {
                    if (!directory.mkdirs()) {
                        throw new Exception();
                    }
                }
                for (MultipartFile file : files) {
                    String format = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                    String name = System.currentTimeMillis() + format;
                    file.transferTo(new File(sysPath+name));
                    Image image = img.addImage(path + name + format);
                    image.setPost(post);
                    post.addFile(image);
                    postService.savePost(post);
                    img.save(image);
                }
            }
            return ResponseEntity.status(200).body("""
            {"status": "success", "message": "Upload Success."}      
            """);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
                    {"status": "error", "message": "Internal Server Error"}
                    """);
        }
    }

    /// <게시글 삭제>
    @DeleteMapping
    public ResponseEntity<?> apiDeletePost(@RequestBody DeletePostDTO deletePostDTO) {
        try {
            postService.deletePost(deletePostDTO.getPostSn());
            return ResponseEntity.ok().body("""
                    {"status": "success", "message": "Post deleted successfully"}
                    """);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
                    {"status": "error", "message": "Internal Server Error"}
                    """);
        }
    }

    // <게시글 수정>
    @PutMapping("/{postSn}")
    public ResponseEntity<?> apiUpdatePost(@PathVariable Long postSn, @RequestBody UploadPostDTO postDTO) {
        try {
            Post post = postService.updatePost(postSn, postDTO);
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
    // /// <게시글 수정 및 파일 첨부>
    // @PutMapping("/{postSn}")
    // public ResponseEntity<?> apiUpdatePost(
    //         @PathVariable Long postSn,
    //         @RequestParam("files") MultipartFile[] files,
    //         @RequestParam("data") UploadPostDTO uploadPostDTO) {
    //     try {
    //         // 게시글 업데이트
    //         Post post = postService.updatePost(postSn, uploadPostDTO);

    //         // 파일 저장 로직 구현
    //         List<Image> savedImages = new ArrayList<>();
    //         for (MultipartFile file : files) {
    //             if (!file.isEmpty()) {
    //                 Path filePath = Paths.get(uploadDir + post.getSn() + "/" + file.getOriginalFilename());
    //                 Files.createDirectories(filePath.getParent());
    //                 Files.write(filePath, file.getBytes());

    //                 Image savedImage = new Image();
    //                 savedImage.setPath(filePath.toString());
    //                 savedImage.setPost(post);
    //                 savedImages.add(savedImage);
    //             }
    //         }
    //         post.getImages().addAll(savedImages);
    //         postService.savePost(post);

    //         PostDTO responseDTO = new PostDTO(post);
    //         return ResponseEntity.ok().body(responseDTO);
    //     } catch (IOException e) {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
    //             {"status": "error", "message": "Internal Server Error"}
    //             """);
    //     }
    // }
// @PostMapping{"/upload/}
// public ResponseEntity<?> apiUploadPost(
//         @RequestParam("files") MultipartFile[] files,
//         @RequestParam("data") UploadPostDTO data,
//         @PathVariable Long postSn) {
//     //파일 저장 경로 = uploads/{post.sn 값을 이용해서 작성}
//     return ResponseEntity.ok().build();
// }
/// <특정 게시판 내 모든 게시글 조회>
//    @GetMapping
//    public ResponseEntity<?> apiGetAllPosts() {
//        try {
//            List<Post> posts = postService.getAllPostsByBoardId(bbs);
//            List<PostDTO> postDTOs = posts.stream()
//                                          .map(post -> new PostDTO(post))
//                                          .toList(); // Java 16 이상
//            return ResponseEntity.ok().body("""
//                {"status": "success", "data": %s}
//                """.formatted(postDTOs));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
//                {"status": "error", "message": "Internal Server Error"}
//                """);
//        }
//    }


//    /// <특정 게시판 내 특정 게시글 조회>
//    @GetMapping("/{postId}")
//    public ResponseEntity<?> apiGetPostByID(@PathVariable Long bbs, @PathVariable Long postId) {
//        try {
//            Post post = postService.getPostBySn(postId);
//            if (post == null) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("""
//                    {"status": "error", "message": "Post not found"}
//                    """);
//            }
//            PostDTO postDTO = new PostDTO(post);
//            return ResponseEntity.ok().body("""
//                {"status": "success", "data": %s}
//                """.formatted(postDTO));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
//                {"status": "error", "message": "Internal Server Error"}
//                """);
//        }
//    }
//

/// <특정 게시판 내 게시글 추가>
//    @PostMapping
//    public ResponseEntity<?> apiCreatePost(@RequestBody PostDTO postDTO) {
//        try {
//            Post post = postService.createPost(postDTO);
//            PostDTO responseDTO = new PostDTO(post);
//            return ResponseEntity.ok().body("""
//                {"status": "success", "data": %s}
//                """.formatted(responseDTO));
//            } catch (Exception e) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
//                    {"status": "error", "message": "Internal Server Error"}
//                    """);
//            }
//        }
// @GetMapping
// public ResponseEntity<List<Post>> apiGetAllPosts(@PathVariable Long postSn) {
//     try {
//         List<Post> posts = postService.getAllPostsByBoardId(postSn);
//         List<PostDTO> postDTOs = posts.stream()
//                                       .map(post -> new PostDTO(post))
//                                       .toList(); // Java 16 이상
//         return ResponseEntity.ok(postDTOs).body("""
//             {"status": "success", "data": %s}
//             """.formatted(postDTOs));
//     } catch (Exception e) {
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
//             {"status": "error", "message": "Internal Server Error"}
//             """);
//     }
// }


// /// <특정 게시판 내 특정 게시글 조회>
// @GetMapping
// public ResponseEntity<?> apiGetPostByID(@PathVariable Long postSn) {
//     try {
//         Post post = postService.getPostBySn(postId);
//         if (post == null) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("""
//                 {"status": "error", "message": "Post not found"}
//                 """);
//         }
//         PostDTO postDTO = new PostDTO(post);
//         return ResponseEntity.ok().body("""
//             {"status": "success", "data": %s}
//             """.formatted(postDTO));
//     } catch (Exception e) {
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("""
//             {"status": "error", "message": "Internal Server Error"}
//             """);
//     }
// }


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
// key: status message
//status: success error
//message: english