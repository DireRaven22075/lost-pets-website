package team.ccnu.project.domain.entity.board;

import java.sql.Date;

import jakarta.persistence.*;
import team.ccnu.project.domain.entity.MemberEntity;


@Entity
@Table(name="board_comment")
public class PostCommentEntity {
    @Id
    @Column(name="PST_SN")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;
}