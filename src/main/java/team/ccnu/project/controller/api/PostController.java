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

import team.ccnu.project.data.request.DeletePostDTO;
import team.ccnu.project.data.request.UploadPostDTO;
import team.ccnu.project.data.response.PostDTO;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.service.PostService;


@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    private final String uploadDir = "uploads/";

    /// <게시글 추가>
    @PostMapping
    public ResponseEntity<?> apiCreatePost(@RequestBody UploadPostDTO postDTO) {
        try {
            Post post = postService.createPost(postDTO);
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