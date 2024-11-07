package team.ccnu.project.domain.entity.board;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    @Column(name="PST_CONTENT")
    private String content;


    @OneToMany
    private LinkedHashSet<PostCommentEntity> comments = new LinkedHashSet<>();
}