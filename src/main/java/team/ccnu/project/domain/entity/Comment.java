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
}
