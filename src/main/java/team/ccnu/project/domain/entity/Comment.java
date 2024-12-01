package team.ccnu.project.domain.entity;

import jakarta.persistence.*;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@Entity
public class Comment {
    //PK
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sn;

    //FK
    @ManyToOne
    @JoinColumn(name = "post_sn")
    private Post post;

    //FK
    @ManyToOne
    @JoinColumn(name = "user_sn")
    private User user;

    //DATA COLUMN
    private String content;

    // 답글 기능을 위한 추가 필드
    @ManyToOne
    @JoinColumn(name = "parent_comment_sn") // 부모댓글 참조 가능
    private Comment parentComment;
    // 답글 기능을 위한 추가 필드
    @Column(name = "is_reply")              // 댓글인지 답글인지 여부 표시
    private boolean isReply = false;
}