package team.ccnu.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.ccnu.project.domain.entity.Comment;
import team.ccnu.project.domain.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllCommentsByPostSn(Long postSn) {
        return commentRepository.findByPostSn(postSn);
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Optional<Comment> getCommentBySn(Long sn) {
        return commentRepository.findById(sn);
    }

    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(Long sn) {
        commentRepository.deleteById(sn);
    }
}