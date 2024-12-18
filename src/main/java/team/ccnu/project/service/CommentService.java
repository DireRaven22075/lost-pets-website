package team.ccnu.project.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.ccnu.project.data.request.UploadCommentDTO;
import team.ccnu.project.data.request.UploadReplyDTO;
import team.ccnu.project.domain.entity.Comment;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.domain.entity.User;
import team.ccnu.project.domain.repository.CommentRepository;
import team.ccnu.project.domain.repository.PostRepository;
import team.ccnu.project.domain.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private PostRepository pst;
    @Autowired
    private UserRepository mem;
    @Autowired
    private CommentRepository cmnt;
    @Autowired
    private CommentRepository commentRepository;

    public void addReply(UploadReplyDTO dto, HttpSession session) {
        Post post = pst.findBySn(dto.getPst());
        if (post == null) {
            throw new IllegalArgumentException("Post not found for sn: " + dto.getPst());
        }

        User user = mem.findBySn((Long) session.getAttribute("token"));
        if (user == null) {
            throw new IllegalArgumentException("User not found for token: " + session.getAttribute("token"));
        }

        if (dto.getText() == null || dto.getText().isEmpty()) {
            throw new IllegalArgumentException("Comment content must not be null or empty");
        }

        Comment comment = new Comment();
        comment.setPost(post);
        comment.setContent(dto.getText());
        comment.setParent(cmnt.findBySn(dto.getCmnt()));
        comment.setUser(user);

        cmnt.save(comment);
        pst.save(post);
    }

    public boolean addComment(UploadCommentDTO dto, HttpSession session) {
        Post post = pst.findBySn(dto.getSn());
        if (post == null) {
            throw new IllegalArgumentException("Post not found for sn: " + dto.getSn());
        }

        User user = mem.findBySn((Long) session.getAttribute("token"));
        if (user == null) {
            throw new IllegalArgumentException("User not found for token: " + session.getAttribute("token"));
        }

        if (dto.getText() == null || dto.getText().isEmpty()) {
            throw new IllegalArgumentException("Comment content must not be null or empty");
        }

        Comment comment = new Comment();
        comment.setPost(post);
        comment.setContent(dto.getText());
        comment.setParent(null); // 수정하려는 댓글이 없으므로 null
        comment.setUser(user);

        cmnt.save(comment);
        pst.save(post);

        return true;
    }

    public List<Comment> getAllCommentsByPostSn(Long postSn) {
        return commentRepository.findByPost_Sn(postSn);
    }

    public Comment addComment(UploadCommentDTO dto, Long postId) {
        Comment comment = new Comment();
        comment.setContent(dto.getText());
        return commentRepository.save(comment);
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