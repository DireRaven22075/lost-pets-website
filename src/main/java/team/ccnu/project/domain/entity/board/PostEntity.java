package team.ccnu.project.domain.entity.board;

import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import team.ccnu.project.domain.entity.MemberEntity;

//게시글 엔티티

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="board_data")
public class PostEntity {
    @Id
    @Column(name="PST_SN")
    private Long sn;
    @Column(name="PST_TITLE")
    private String title;
    @Column(name="PST_VIEW_CNT")
    @ColumnDefault("0")
    private int viewCount;
    @Column(name="PST_LIKE_CNT")
    @ColumnDefault("0")
    private int likeCount;
    @Column(name="PST_STATUS")
    @ColumnDefault("R")
    private char state;
    @Lob
    @Column(name="PST_CONTENT")
    private String content;

    @ManyToOne
    @JoinColumn(name="MEM_SN")
    private MemberEntity owner;

    @OneToMany

    private LinkedHashSet<PostCommentEntity> comments = new LinkedHashSet<>();

    @CreationTimestamp
    private Timestamp createTime;
}