package team.ccnu.project.controller.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards/{boardId}/posts")
public class PostController {
    /// <summary>
    /// TODO : 구현 필요
    /// 특정 게시판 내 모든 게시글 불러오기
    /// METHOD : GET
    /// RETURN : JSON
    /// URL : /api/boards/{boardId}/posts
    /// </summary>
    @GetMapping
    public String getAllPosts(@PathVariable String boardId) {

        return "success";
    }
    /// <summary>
    /// TODO : 구현 필요
    /// 특정 게시판 내 게시글을 추가
    ///
    /// [POST] 특정 게시판 내 게시글을 추가하하는 함수
    /// </summary>
    @PostMapping("")
    public String addPost(@PathVariable String boardId) {
        return "success";
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