package team.ccnu.project.domain.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@Entity
public class Comment {
    //PK
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cmnt_sn")
    private long sn;
    //FK
    @ManyToOne
    @JoinColumn(name="post_sn")
    private Post post;

    //FK
    @ManyToOne
    @JoinColumn(name="comment_sn")
    private Comment parent;

    //FK
    @ManyToOne
    @JoinColumn(name="user_sn")
    private User user;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> replies = new ArrayList<>();

    @Lob
    @Column(name="comment_content")
    private String content;
}
