package team.ccnu.project.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.Builder
@Entity
public class Post {
    //PK
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_sn")
    private long sn; // 게시글 ID
    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_sn", nullable = false)
    private User user; // 게시글 작성자
    //FK
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
    //FK
    @OneToMany(mappedBy="post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

    // DATA COLUMN
    @Column(name="post_bbs")
    private Long uid; // 게시판 ID
    @Column(name="post_title", length=100)
    private String title; // 제목
    @Column(name="post_content", columnDefinition = "TEXT")
    private String content; // 내용
    @ColumnDefault("0") private Long view; // 조회수
    @ColumnDefault("'Y'")
    private char status; // 상태 (입양 여부)
    @CreationTimestamp
    @Column(name="post_reg_dt")
    private LocalDateTime regDate;
    @UpdateTimestamp
    @Column(name="post_mdfcn_dt")
    private LocalDateTime modifyDate;
}
